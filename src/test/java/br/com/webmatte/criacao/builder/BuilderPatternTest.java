package br.com.webmatte.criacao.builder;

import br.com.webmatte.criacao.builder.gerador.GeradorDeProtocolo;
import br.com.webmatte.criacao.builder.interfaces.ProtocoloExperimental;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testes do Padrão Builder - Protocolos Experimentais")
class BuilderPatternTest {

    private GeradorDeProtocolo gerador;

    @BeforeEach
    void setUp() {
        gerador = new GeradorDeProtocolo();
    }

    @Test
    @DisplayName("Deve construir protocolo completo")
    void deveConstruirProtocoloCompleto() {
        // Given
        String nomePesquisador = "Dr. João Silva";
        String tipoAmostra = "Sangue";
        Double volumeAmostra = 10.0;
        LocalDate dataInicio = LocalDate.of(2024, 1, 15);
        int duracaoHoras = 24;
        String metodoAnalise = "PCR";

        // When
        ProtocoloExperimental protocolo = gerador
                .comNomePesquisador(nomePesquisador)
                .comTipoAmostra(tipoAmostra)
                .comVolumeAmostra(volumeAmostra)
                .comDataInicio(dataInicio)
                .comDuracaoHoras(duracaoHoras)
                .comMetodoAnalise(metodoAnalise)
                .getProtocolo();

        // Then
        assertNotNull(protocolo);
        assertEquals(nomePesquisador, protocolo.getNomePesquisador());
        assertEquals(tipoAmostra, protocolo.getTipoAmostra());
        assertEquals(volumeAmostra, protocolo.getVolumeAmostra());
        assertEquals(dataInicio, protocolo.getDataInicio());
        assertEquals(duracaoHoras, protocolo.getDuracaoHoras());
        assertEquals(metodoAnalise, protocolo.getMetodoAnalise());
    }

    @Test
    @DisplayName("Deve construir protocolo com parâmetros padrão")
    void deveConstruirProtocoloComParametrosPadrao() {
        // When
        ProtocoloExperimental protocolo = gerador.getProtocolo();

        // Then
        assertNotNull(protocolo);
        assertNotNull(protocolo.getNomePesquisador());
        assertNotNull(protocolo.getTipoAmostra());
        assertNotNull(protocolo.getVolumeAmostra());
        assertNotNull(protocolo.getDataInicio());
        assertTrue(protocolo.getDuracaoHoras() > 0);
        assertNotNull(protocolo.getMetodoAnalise());
    }

    @Test
    @DisplayName("Deve permitir construção incremental")
    void devePermitirConstrucaoIncremental() {
        // When
        gerador.comNomePesquisador("Dr. Maria Santos");
        gerador.comTipoAmostra("Tecido");
        gerador.comVolumeAmostra(5.0);

        ProtocoloExperimental protocoloParcial = gerador.getProtocolo();

        // Then
        assertEquals("Dr. Maria Santos", protocoloParcial.getNomePesquisador());
        assertEquals("Tecido", protocoloParcial.getTipoAmostra());
        assertEquals(5.0, protocoloParcial.getVolumeAmostra());

        // Outros campos devem ter valores padrão
        assertNotNull(protocoloParcial.getDataInicio());
        assertTrue(protocoloParcial.getDuracaoHoras() > 0);
        assertNotNull(protocoloParcial.getMetodoAnalise());
    }

    @Test
    @DisplayName("Deve construir múltiplos protocolos independentes")
    void deveConstruirMultiplasProtocolosIndependentes() {
        // When
        ProtocoloExperimental protocolo1 = gerador
                .comNomePesquisador("Pesquisador 1")
                .comTipoAmostra("Sangue")
                .getProtocolo();

        ProtocoloExperimental protocolo2 = gerador
                .comNomePesquisador("Pesquisador 2")
                .comTipoAmostra("Saliva")
                .getProtocolo();

        // Then
        assertNotSame(protocolo1, protocolo2);
        assertEquals("Pesquisador 1", protocolo1.getNomePesquisador());
        assertEquals("Sangue", protocolo1.getTipoAmostra());
        assertEquals("Pesquisador 2", protocolo2.getNomePesquisador());
        assertEquals("Saliva", protocolo2.getTipoAmostra());
    }

    @Test
    @DisplayName("Deve validar integridade dos dados")
    void deveValidarIntegridadeDosDados() {
        // Given
        String nomePesquisador = "Dr. Teste";
        String tipoAmostra = "Sangue";

        // When
        ProtocoloExperimental protocolo = gerador
                .comNomePesquisador(nomePesquisador)
                .comTipoAmostra(tipoAmostra)
                .getProtocolo();

        // Then
        assertTrue(protocolo.toString().contains(nomePesquisador));
        assertTrue(protocolo.toString().contains(tipoAmostra));
    }
}
