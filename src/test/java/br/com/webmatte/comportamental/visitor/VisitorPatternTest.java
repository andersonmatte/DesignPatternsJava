package br.com.webmatte.comportamental.visitor;

import br.com.webmatte.comportamental.visitor.control.AnaliseGenetica;
import br.com.webmatte.comportamental.visitor.entity.GeneProteina;
import br.com.webmatte.comportamental.visitor.entity.GeneRegulador;
import br.com.webmatte.comportamental.visitor.visitor.AnalisadorMolecular;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testes do Padrão Visitor - Análise de Genes")
class VisitorPatternTest {

    private AnaliseGenetica analise;
    private AnalisadorMolecular analisador;

    @BeforeEach
    void setUp() {
        analise = new AnaliseGenetica();
        analisador = new AnalisadorMolecular();
    }

    @Test
    @DisplayName("Deve analisar gene de proteína")
    void deveAnalisarGeneDeProteina() {
        // Given
        GeneProteina geneProteina = new GeneProteina("GENE_HBB", "Hemoglobina Beta", "ATCGATCG");

        // When
        geneProteina.aceitar(analisador);
        String resultado = analisador.getResultado();

        // Then
        assertNotNull(resultado);
        assertTrue(resultado.contains("Analisando gene de proteína"));
        assertTrue(resultado.contains("Nome: GENE_HBB"));
        assertTrue(resultado.contains("Sequência: ATCGATCG"));
        assertTrue(resultado.contains("Estrutura terciária: Predita"));
        assertTrue(resultado.contains("Função: Transporte de oxigênio"));
    }

    @Test
    @DisplayName("Deve analisar gene regulador")
    void deveAnalisarGeneRegulador() {
        // Given
        GeneRegulador geneRegulador = new GeneRegulador("GENE_P53", "Proteína P53", "GCTAGCTA");

        // When
        geneRegulador.aceitar(analisador);
        String resultado = analisador.getResultado();

        // Then
        assertNotNull(resultado);
        assertTrue(resultado.contains("Analisando gene regulador"));
        assertTrue(resultado.contains("Nome: GENE_P53"));
        assertTrue(resultado.contains("Sequência: GCTAGCTA"));
        assertTrue(resultado.contains("Sítios de ligação: Identificados"));
        assertTrue(resultado.contains("Regulação: Supressora de tumor"));
    }

    @Test
    @DisplayName("Deve processar múltiplos genes com mesmo visitor")
    void deveProcessarMultiplosGenesComMesmoVisitor() {
        // Given
        GeneProteina gene1 = new GeneProteina("GENE_001", "Proteína 1", "ATCG");
        GeneRegulador gene2 = new GeneRegulador("GENE_002", "Proteína 2", "GCTA");
        GeneProteina gene3 = new GeneProteina("GENE_003", "Proteína 3", "TTAG");

        // When
        gene1.aceitar(analisador);
        gene2.aceitar(analisador);
        gene3.aceitar(analisador);

        // Then
        String resultado = analisador.getResultado();
        assertTrue(resultado.contains("GENE_001"));
        assertTrue(resultado.contains("GENE_002"));
        assertTrue(resultado.contains("GENE_003"));
        assertEquals(3, analisador.getTotalGenesAnalisados());
    }

    @Test
    @DisplayName("Deve permitir diferentes tipos de análise")
    void devePermitirDiferentesTiposDeAnalise() {
        // Given
        GeneProteina gene = new GeneProteina("GENE_TESTE", "Proteína Teste", "ATCGATCG");

        // When - Análise de expressão
        gene.aceitar(analisador);
        String resultadoExpressao = analisador.getResultado();

        // Reset e nova análise
        analisador.resetar();
        gene.aceitar(analisador);
        String resultadoEstrutura = analisador.getResultado();

        // Then - Resultados devem ser iguais (mesmo gene, mesmo visitor)
        assertNotNull(resultadoExpressao);
        assertNotNull(resultadoEstrutura);
        assertEquals(resultadoExpressao, resultadoEstrutura);

        // Verificar que contêm as informações esperadas
        assertTrue(resultadoExpressao.contains("GENE_TESTE"));
        assertTrue(resultadoExpressao.contains("Analisando gene de proteína"));
    }

    @Test
    @DisplayName("Deve manter estado do visitor entre análises")
    void deveManterEstadoDoVisitorEntreAnalises() {
        // Given
        GeneProteina gene1 = new GeneProteina("GENE_001", "Proteína 1", "ATCG");
        GeneRegulador gene2 = new GeneRegulador("GENE_002", "Proteína 2", "GCTA");

        // When
        gene1.aceitar(analisador);
        gene2.aceitar(analisador);

        // Then
        assertEquals(2, analisador.getTotalGenesAnalisados());
        assertTrue(analisador.getGenesAnalisados().contains("GENE_001"));
        assertTrue(analisador.getGenesAnalisados().contains("GENE_002"));
    }

    @Test
    @DisplayName("Deve suportar operação de análise genômica")
    void deveSuportarOperacaoDeAnaliseGenomica() {
        // Given
        GeneProteina gene = new GeneProteina("GENE_001", "Proteína Teste", "ATCGATCG");
        GeneRegulador geneRegulador = new GeneRegulador("GENE_002", "Proteína Reguladora", "GCTAGCTA");

        // When
        analise.adicionarGene(gene);
        analise.adicionarGene(geneRegulador);
        String resultado = analise.executarAnaliseGenomica();

        // Then
        assertNotNull(resultado);
        assertTrue(resultado.contains("Iniciando análise genômica"));
        assertTrue(resultado.contains("Analisando gene de proteína"));
        assertTrue(resultado.contains("Analisando gene regulador"));
        assertTrue(resultado.contains("Análise genômica concluída"));
    }
}
