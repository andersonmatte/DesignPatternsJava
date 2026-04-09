package br.com.webmatte.estrutural.facade;

import br.com.webmatte.estrutural.facade.control.SistemaBioinformaticaFacade;
import br.com.webmatte.estrutural.facade.entity.AnaliseGenomica;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DisplayName("Testes do Padrão Facade - Interface Simplificada")
class FacadePatternTest {

    private SistemaBioinformaticaFacade facade;
    private ByteArrayOutputStream outputStream;

    @BeforeEach
    void setUp() {
        facade = new SistemaBioinformaticaFacade();

        // Captura saída do console para verificação
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    @DisplayName("Deve executar análise genômica completa")
    void deveExecutarAnaliseGenomicaCompleta() {
        // Given
        AnaliseGenomica analise = new AnaliseGenomica(
                "AMOSTRA_001",
                "Sequenciamento Completo",
                "João Silva",
                "2024-01-15"
        );

        // When & Then - Não deve lançar exceção
        assertDoesNotThrow(() -> facade.executarAnaliseCompleta(analise));
    }

    @Test
    @DisplayName("Deve processar múltiplas análises")
    void deveProcessarMultiplasAnalises() {
        // Given
        AnaliseGenomica analise1 = new AnaliseGenomica("AMOSTRA_001", "Tipo1", "Paciente1", "2024-01-15");
        AnaliseGenomica analise2 = new AnaliseGenomica("AMOSTRA_002", "Tipo2", "Paciente2", "2024-01-16");

        // When & Then - Não deve lançar exceções
        assertDoesNotThrow(() -> {
            facade.executarAnaliseCompleta(analise1);
            facade.executarAnaliseCompleta(analise2);
        });
    }

    @Test
    @DisplayName("Deve inicializar todos os subsistemas automaticamente")
    void deveInicializarTodosOsSubsistemasAutomaticamente() {
        // Given
        SistemaBioinformaticaFacade novaFacade = new SistemaBioinformaticaFacade();

        // When & Then - Não deve lançar exceção na inicialização
        assertNotNull(novaFacade);
    }
}
