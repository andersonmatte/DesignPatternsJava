package br.com.webmatte.comportamental.mediator;

import br.com.webmatte.comportamental.mediator.colleague.AlinhadorSequencias;
import br.com.webmatte.comportamental.mediator.colleague.AnalisadorExpressao;
import br.com.webmatte.comportamental.mediator.colleague.ValidadorDados;
import br.com.webmatte.comportamental.mediator.control.SistemaBioinformaticaMediator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testes do Padrão Mediator - Comunicação entre Componentes")
class MediatorPatternTest {

    private SistemaBioinformaticaMediator mediator;
    private AnalisadorExpressao analisador;
    private AlinhadorSequencias alinhador;
    private ValidadorDados validador;

    @BeforeEach
    void setUp() {
        mediator = new SistemaBioinformaticaMediator();
        analisador = new AnalisadorExpressao(mediator);
        alinhador = new AlinhadorSequencias(mediator);
        validador = new ValidadorDados(mediator);
    }

    @Test
    @DisplayName("Deve configurar mediator com todos os componentes")
    void deveConfigurarMediatorComTodosOsComponentes() {
        // When & Then
        assertEquals(3, mediator.getTotalComponentes());
        assertTrue(mediator.temComponente(analisador));
        assertTrue(mediator.temComponente(alinhador));
        assertTrue(mediator.temComponente(validador));
    }

    @Test
    @DisplayName("Deve comunicar componentes através do mediator")
    void deveComunicarComponentesAtravesDoMediator() {
        // Given
        String mensagem = "DADOS_PARA_ANALISE";
        String origem = "ANALISADOR";

        // When
        analisador.enviarMensagem(mensagem, origem);

        // Then
        assertTrue(alinhador.recebeuMensagem());
        assertTrue(validador.recebeuMensagem());
        assertEquals(mensagem, alinhador.getUltimaMensagemRecebida());
        assertEquals(mensagem, validador.getUltimaMensagemRecebida());
        assertEquals(origem, alinhador.getOrigemUltimaMensagem());
        assertEquals(origem, validador.getOrigemUltimaMensagem());
    }

    @Test
    @DisplayName("Deve permitir comunicação seletiva")
    void devePermitirComunicacaoSeletiva() {
        // Given
        String mensagem = "DADOS_ESPECIFICOS";
        String origem = "VALIDADOR";
        String destino = "ANALISADOR";

        // When
        validador.enviarMensagemEspecifica(mensagem, origem, destino);

        // Then
        assertTrue(analisador.recebeuMensagem());
        assertFalse(alinhador.recebeuMensagem());
        assertEquals(mensagem, analisador.getUltimaMensagemRecebida());
        assertEquals(origem, analisador.getOrigemUltimaMensagem());
    }

    @Test
    @DisplayName("Deve processar resposta em cadeia")
    void deveProcessarRespostaEmCadeia() {
        // Given
        String mensagemInicial = "INICIAR_ANALISE";
        analisador.enviarMensagem(mensagemInicial, "SISTEMA");

        // When - Alinhador processa e responde
        alinhador.processarMensagem();

        // Then - Validador deve receber a resposta
        assertTrue(validador.recebeuMensagem());
        assertTrue(validador.getUltimaMensagemRecebida().contains("RESULTADO"));
    }

    @Test
    @DisplayName("Deve remover componente do mediator")
    void deveRemoverComponenteDoMediator() {
        // Given
        assertEquals(3, mediator.getTotalComponentes());

        // When
        mediator.removerComponente(validador);

        // Then
        assertEquals(2, mediator.getTotalComponentes());
        assertTrue(mediator.temComponente(analisador));
        assertTrue(mediator.temComponente(alinhador));
        assertFalse(mediator.temComponente(validador));

        // Mensagem não deve mais chegar ao componente removido
        analisador.enviarMensagem("TESTE", "ORIGEM");
        assertFalse(validador.recebeuMensagem());
    }

    @Test
    @DisplayName("Deve manter histórico de comunicação")
    void deveManterHistoricoDeComunicacao() {
        // Given
        String[] mensagens = {"MSG1", "MSG2", "MSG3"};
        String[] origens = {"ORIG1", "ORIG2", "ORIG3"};

        // When
        for (int i = 0; i < mensagens.length; i++) {
            analisador.enviarMensagem(mensagens[i], origens[i]);
        }

        // Then
        assertEquals(3, mediator.getTotalMensagensEnviadas());
        assertTrue(mediator.temNoHistorico(mensagens[0]));
        assertTrue(mediator.temNoHistorico(mensagens[1]));
        assertTrue(mediator.temNoHistorico(mensagens[2]));
    }

    @Test
    @DisplayName("Deve funcionar sem componentes")
    void deveFuncionarSemComponentes() {
        // Given
        SistemaBioinformaticaMediator mediatorVazio = new SistemaBioinformaticaMediator();

        // When & Then
        assertEquals(0, mediatorVazio.getTotalComponentes());
        assertDoesNotThrow(() -> {
            mediatorVazio.broadcast("MENSAGEM_TESTE", "ORIGEM");
        });
    }
}
