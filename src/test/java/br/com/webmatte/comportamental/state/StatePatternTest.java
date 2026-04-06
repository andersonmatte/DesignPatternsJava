package br.com.webmatte.comportamental.state;

import br.com.webmatte.comportamental.state.control.Celula;
import br.com.webmatte.comportamental.state.state.CelulaCancerigena;
import br.com.webmatte.comportamental.state.state.CelulaNormal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testes do Padrão State - Estados de Células")
class StatePatternTest {

    private Celula celula;

    @BeforeEach
    void setUp() {
        celula = new Celula("CELULA_001");
    }

    @Test
    @DisplayName("Deve iniciar em estado normal")
    void deveIniciarEmEstadoNormal() {
        // When & Then
        assertTrue(celula.getEstado() instanceof CelulaNormal);
        assertEquals("Normal", celula.getStatus());
        assertFalse(celula.isCancerigena());
    }

    @Test
    @DisplayName("Deve transitar para estado cancerígeno quando mutação detectada")
    void deveTransitarParaEstadoCancerigenoQuandoMutacaoDetectada() {
        // When
        celula.detectarMutacao();

        // Then
        assertTrue(celula.getEstado() instanceof CelulaCancerigena);
        assertEquals("Cancerígena", celula.getStatus());
        assertTrue(celula.isCancerigena());
    }

    @Test
    @DisplayName("Deve permanecer em estado cancerígeno após múltiplas mutações")
    void devePermanecerEmEstadoCancerigenoAposMultiplasMutacoes() {
        // Given
        celula.detectarMutacao();
        assertTrue(celula.getEstado() instanceof CelulaCancerigena);

        // When - Múltiplas detecções
        celula.detectarMutacao();
        celula.detectarMutacao();

        // Then - Deve permanecer no mesmo estado
        assertTrue(celula.getEstado() instanceof CelulaCancerigena);
        assertEquals("Cancerígena", celula.getStatus());
    }

    @Test
    @DisplayName("Deve executar comportamento específico do estado normal")
    void deveExecutarComportamentoEspecificoDoEstadoNormal() {
        // Given
        assertTrue(celula.getEstado() instanceof CelulaNormal);

        // When
        String resultado = celula.dividir();

        // Then
        assertEquals("Célula normal dividindo-se", resultado);
        assertEquals("Normal", celula.getStatus());
    }

    @Test
    @DisplayName("Deve executar comportamento específico do estado cancerígeno")
    void deveExecutarComportamentoEspecificoDoEstadoCancerigeno() {
        // Given
        celula.detectarMutacao();
        assertTrue(celula.getEstado() instanceof CelulaCancerigena);

        // When
        String resultado = celula.dividir();

        // Then
        assertEquals("Célula cancerígena dividindo-se descontroladamente", resultado);
        assertEquals("Cancerígena", celula.getStatus());
    }

    @Test
    @DisplayName("Deve permitir tratamento em estado cancerígeno")
    void devePermitirTratamentoEmEstadoCancerigeno() {
        // Given
        celula.detectarMutacao();
        assertTrue(celula.isCancerigena());

        // When
        celula.aplicarTratamento();

        // Then
        assertTrue(celula.getEstado() instanceof CelulaNormal);
        assertEquals("Normal", celula.getStatus());
        assertFalse(celula.isCancerigena());
    }

    @Test
    @DisplayName("Deve manter consistência do estado")
    void deveManterConsistenciaDoEstado() {
        // Given
        celula.detectarMutacao();
        CelulaCancerigena estadoCancerigeno = (CelulaCancerigena) celula.getEstado();

        // When
        String resultadoDivisao = celula.divisao();

        // Then - O estado não deve mudar durante a divisão
        assertSame(estadoCancerigeno, celula.getEstado());
        assertEquals("Célula cancerígena dividindo-se descontroladamente", resultadoDivisao);
    }
}
