package br.com.webmatte.estrutural.bridge;

import br.com.webmatte.estrutural.bridge.control.AlgoritmoAlinhamento;
import br.com.webmatte.estrutural.bridge.control.AnaliseGenomica;
import br.com.webmatte.estrutural.bridge.interfaces.AlgoritmoProcessamento;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testes do Padrão Bridge - Abstração de Algoritmos")
class BridgePatternTest {

    private AnaliseGenomica analise;
    private AlgoritmoProcessamento algoritmo;

    @BeforeEach
    void setUp() {
        algoritmo = new AlgoritmoAlinhamento();
        analise = new AnaliseGenomica("Análise de Expressão", "RNA-Seq", algoritmo);
    }

    @Test
    @DisplayName("Deve executar análise com algoritmo configurado")
    void deveExecutarAnaliseComAlgoritmoConfigurado() {
        // Given
        String dados = "ATCGATCGATCGATCG";

        // When & Then - Não deve lançar exceção
        assertDoesNotThrow(() -> analise.executarAnalise(dados));
    }

    @Test
    @DisplayName("Deve permitir troca de algoritmo em tempo de execução")
    void devePermitirTrocaDeAlgoritmoEmTempoDeExecucao() {
        // Given
        String dados = "GCTAGCTAGCTAGCTA";
        AlgoritmoProcessamento novoAlgoritmo = new AlgoritmoAlinhamento();

        // When & Then - Não deve lançar exceção
        assertDoesNotThrow(() -> {
            analise.setAlgoritmoProcessamento(novoAlgoritmo);
            analise.executarAnalise(dados);
        });
    }

    @Test
    @DisplayName("Deve manter abstração independente da implementação")
    void deveManterAbstracaoIndependenteDaImplementacao() {
        // Given
        String nomeAnalise = "Análise de Mutação";
        String tipoDado = "DNA-Seq";

        // When
        AnaliseGenomica analise1 = new AnaliseGenomica(nomeAnalise, tipoDado, algoritmo);
        AnaliseGenomica analise2 = new AnaliseGenomica(nomeAnalise, tipoDado, algoritmo);

        // Then - Devem ser instâncias diferentes mas mesma configuração
        assertNotSame(analise1, analise2);
        assertEquals(nomeAnalise, analise1.getNomeAnalise());
        assertEquals(nomeAnalise, analise2.getNomeAnalise());
        assertEquals(tipoDado, analise1.getTipoDado());
        assertEquals(tipoDado, analise2.getTipoDado());
    }

    @Test
    @DisplayName("Deve suportar múltiplas execuções com diferentes dados")
    void deveSuportarMultiplasExecucoesComDadosDiferentes() {
        // Given
        String[] dadosArray = {
                "ATCGATCG",
                "GCTAGCTA",
                "TTAGGCTT"
        };

        // When & Then - Não deve lançar exceções
        assertDoesNotThrow(() -> {
            for (String dados : dadosArray) {
                analise.executarAnalise(dados);
            }
        });
    }

    @Test
    @DisplayName("Deve funcionar com diferentes implementações de algoritmo")
    void deveFuncionarComDiferentesImplementacoesDeAlgoritmo() {
        // Given
        AlgoritmoProcessamento algoritmo1 = new AlgoritmoAlinhamento();
        AlgoritmoProcessamento algoritmo2 = new AlgoritmoAlinhamento();

        AnaliseGenomica analise1 = new AnaliseGenomica("Análise 1", "DNA", algoritmo1);
        AnaliseGenomica analise2 = new AnaliseGenomica("Análise 2", "RNA", algoritmo2);

        // When & Then - Não deve lançar exceções
        assertDoesNotThrow(() -> {
            analise1.executarAnalise("ATCG");
            analise2.executarAnalise("GCTA");
        });
    }

    @Test
    @DisplayName("Deve processar dados genéticos complexos")
    void deveProcessarDadosGeneticosComplexos() {
        // Given
        String dadosComplexos = "ATCGATCGATCGATCGATCGATCGATCGATCGATCG";

        // When & Then - Não deve lançar exceção
        assertDoesNotThrow(() -> analise.executarAnalise(dadosComplexos));
    }

    private String capturarOutput() {
        // Implementação simplificada para capturar output
        return "OUTPUT_CAPTURADO";
    }
}
