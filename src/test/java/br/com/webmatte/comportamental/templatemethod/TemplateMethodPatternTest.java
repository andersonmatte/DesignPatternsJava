package br.com.webmatte.comportamental.templatemethod;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testes do Padrão Template Method - Pipeline de Análise")
class TemplateMethodPatternTest {

    private AnaliseProteomica analiseProteomica;
    private AnaliseGenomica analiseGenomica;

    @BeforeEach
    void setUp() {
        analiseProteomica = new AnaliseProteomica();
        analiseGenomica = new AnaliseGenomica();
    }

    @Test
    @DisplayName("Deve executar pipeline completo de análise de proteomas")
    void deveExecutarPipelineCompletoDeAnaliseDeProteomas() {
        // Given
        String amostra = "AMOSTRA_PROTEOMA_001";

        // When
        analiseProteomica.executarPipelineCompleto(amostra);
        String resultado = analiseProteomica.getResultadoAnalise();

        // Then
        assertNotNull(resultado);
        assertTrue(resultado.contains("Iniciando análise proteômica específica"));
        assertTrue(resultado.contains("Preparando amostra: " + amostra));
        assertTrue(resultado.contains("Separação de proteínas por eletroforese"));
        assertTrue(resultado.contains("Identificação por espectrometria de massa"));
        assertTrue(resultado.contains("Quantificação e análise funcional"));
        assertTrue(resultado.contains("Análise concluída com sucesso"));
    }

    @Test
    @DisplayName("Deve executar pipeline completo de análise de genes")
    void deveExecutarPipelineCompletoDeAnaliseDeGenes() {
        // Given
        String amostra = "AMOSTRA_GENES_001";

        // When
        analiseGenomica.executarPipelineCompleto(amostra);
        String resultado = analiseGenomica.getResultadoAnalise();

        // Then
        assertNotNull(resultado);
        assertTrue(resultado.contains("Iniciando análise genômica específica"));
        assertTrue(resultado.contains("Preparando amostra: " + amostra));
        assertTrue(resultado.contains("Sequenciamento do genoma completo"));
        assertTrue(resultado.contains("Identificação de variantes genéticas"));
        assertTrue(resultado.contains("Anotação funcional dos genes"));
        assertTrue(resultado.contains("Análise concluída com sucesso"));
    }

    @Test
    @DisplayName("Deve seguir ordem fixa do template method")
    void deveSeguirOrdemFixaDoTemplateMethod() {
        // Given
        String amostra = "AMOSTRA_TESTE_001";
        PipelineAnaliseBiologica pipeline = analiseProteomica;

        // When
        pipeline.executarPipelineCompleto(amostra);
        String resultado = pipeline.getResultadoAnalise();
        String[] passos = resultado.split("\n");

        // Then - Verificar ordem dos passos
        assertTrue(passos[0].contains("Preparando amostra"));
        assertTrue(passos[1].contains("Extração de DNA/RNA completada"));
        assertTrue(passos[2].contains("Purificação da amostra realizada"));
        assertTrue(passos[3].contains("Iniciando análise proteômica específica"));
        assertTrue(passos[4].contains("Separação de proteínas por eletroforese"));
        assertTrue(passos[5].contains("Identificação por espectrometria de massa"));
        assertTrue(passos[6].contains("Quantificação e análise funcional"));
        assertTrue(passos[7].contains("Gerando relatório final da análise"));
        assertTrue(passos[8].contains("Análise concluída com sucesso"));
    }

    @Test
    @DisplayName("Deve permitir personalização de passos específicos")
    void devePermitirPersonalizacaoDePassosEspecificos() {
        // Given
        String amostra = "AMOSTRA_TESTE_001";

        // When
        analiseProteomica.executarPipelineCompleto(amostra);
        String resultadoProteomas = analiseProteomica.getResultadoAnalise();

        analiseGenomica.executarPipelineCompleto(amostra);
        String resultadoGenes = analiseGenomica.getResultadoAnalise();

        // Then - Passos específicos devem ser diferentes
        assertTrue(resultadoProteomas.contains("Identificação por espectrometria de massa"));
        assertTrue(resultadoGenes.contains("Sequenciamento do genoma completo"));
        assertFalse(resultadoProteomas.contains("Sequenciamento do genoma completo"));
        assertFalse(resultadoGenes.contains("Identificação por espectrometria de massa"));
    }

    @Test
    @DisplayName("Deve manter estrutura comum do template")
    void deveManterEstruturaComumDoTemplate() {
        // Given
        String amostra1 = "AMOSTRA_001";
        String amostra2 = "AMOSTRA_002";

        // When
        analiseProteomica.executarPipelineCompleto(amostra1);
        String resultado1 = analiseProteomica.getResultadoAnalise();

        analiseGenomica.executarPipelineCompleto(amostra2);
        String resultado2 = analiseGenomica.getResultadoAnalise();

        // Then - Estrutura comum deve ser mantida
        assertTrue(resultado1.contains("Iniciando análise"));
        assertTrue(resultado2.contains("Iniciando análise"));
        assertTrue(resultado1.contains("Preparando amostra"));
        assertTrue(resultado2.contains("Preparando amostra"));
        assertTrue(resultado1.contains("Gerando relatório final"));
        assertTrue(resultado2.contains("Gerando relatório final"));
    }

    @Test
    @DisplayName("Deve processar múltiplas amostras")
    void deveProcessarMultiplasAmostras() {
        // Given
        String[] amostras = {"AMOSTRA_001", "AMOSTRA_002", "AMOSTRA_003"};

        // When
        String[] resultados = new String[3];
        for (int i = 0; i < amostras.length; i++) {
            analiseProteomica.executarPipelineCompleto(amostras[i]);
            resultados[i] = analiseProteomica.getResultadoAnalise();
        }

        // Then
        for (String resultado : resultados) {
            assertNotNull(resultado);
            assertTrue(resultado.contains("Análise concluída com sucesso"));
        }

        // Cada amostra deve ser processada
        assertTrue(resultados[0].contains("AMOSTRA_001"));
        assertTrue(resultados[1].contains("AMOSTRA_002"));
        assertTrue(resultados[2].contains("AMOSTRA_003"));
    }
}
