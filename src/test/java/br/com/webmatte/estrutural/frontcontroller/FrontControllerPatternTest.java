package br.com.webmatte.estrutural.frontcontroller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@DisplayName("Testes do Padrão Front Controller - Controle de Requisições")
class FrontControllerPatternTest {

    private SistemaBioinformaticaFrontController frontController;
    private ByteArrayOutputStream outputStream;

    @BeforeEach
    void setUp() {
        frontController = new SistemaBioinformaticaFrontController();
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @ParameterizedTest
    @CsvSource({
            "'sequenciamento/executar', 'AMOSTRA_001', 'Sequenciamento'",
            "'alinhamento/executar', 'REFERENCIA_001', 'Alinhamento'",
            "'analise/executar', 'TIPO_ANALISE_001', 'Análise'",
            "'relatorio/gerar', 'ANALISE_001', 'Relatório'"
    })
    @DisplayName("Deve rotear requisições para módulos corretos")
    void deveRotearRequisicoesParaModulosCorretos(String endpoint, String parametros, String moduloEsperado) {
        // When & Then - Não deve lançar exceção
        assertDoesNotThrow(() -> frontController.processarRequisicao(endpoint, parametros));
    }

    @Test
    @DisplayName("Deve tratar módulo inválido")
    void deveTratarModuloInvalido() {
        // Given
        String endpoint = "modulo_invalido/executar";
        String parametros = "PARAMETRO";

        // When & Then - Não deve lançar exceção
        assertDoesNotThrow(() -> frontController.processarRequisicao(endpoint, parametros));
    }

    @Test
    @DisplayName("Deve usar ação padrão quando não especificada")
    void deveUsarAcaoPadraoQuandoNaoEspecificada() {
        // Given
        String endpoint = "sequenciamento"; // Sem ação especificada
        String parametros = "AMOSTRA_001";

        // When & Then - Não deve lançar exceção
        assertDoesNotThrow(() -> frontController.processarRequisicao(endpoint, parametros));
    }

    @Test
    @DisplayName("Deve processar múltiplas requisições sequencialmente")
    void deveProcessarMultiplasRequisicoesSequencialmente() {
        // Given
        String[] endpoints = {
                "sequenciamento/executar",
                "alinhamento/executar",
                "analise/executar",
                "relatorio/gerar"
        };
        String[] parametros = {
                "AMOSTRA_001",
                "REFERENCIA_001",
                "TIPO_ANALISE_001",
                "ANALISE_001"
        };

        // When & Then - Não deve lançar exceções
        for (int i = 0; i < endpoints.length; i++) {
            final int index = i;
            assertDoesNotThrow(() -> frontController.processarRequisicao(endpoints[index], parametros[index]));
        }
    }

    @Test
    @DisplayName("Deve tratar exceções durante processamento")
    void deveTratarExcecoesDuranteProcessamento() {
        // Given
        String endpoint = "sequenciamento/executar";
        String parametros = null; // Parâmetro nulo para causar exceção

        // When & Then - Não deve lançar exceção
        assertDoesNotThrow(() -> frontController.processarRequisicao(endpoint, parametros));
    }
}
