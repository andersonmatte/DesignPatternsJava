package br.com.webmatte.comportamental.strategy;

import br.com.webmatte.comportamental.strategy.control.AnaliseBioinformatica;
import br.com.webmatte.comportamental.strategy.strategy.AlgoritmoAlinhamentoGlobal;
import br.com.webmatte.comportamental.strategy.strategy.AlgoritmoAlinhamentoLocal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("Testes do Padrão Strategy - Algoritmos de Alinhamento")
class StrategyPatternTest {

    @Mock
    private AlgoritmoAlinhamentoGlobal algoritmoGlobal;

    @Mock
    private AlgoritmoAlinhamentoLocal algoritmoLocal;

    private AnaliseBioinformatica analise;

    @BeforeEach
    void setUp() {
        analise = new AnaliseBioinformatica();
    }

    @Test
    @DisplayName("Deve executar alinhamento global quando configurado")
    void deveExecutarAlinhamentoGlobalQuandoConfigurado() {
        // Given
        String sequencia1 = "ATCGATCG";
        String sequencia2 = "GCTAGCTA";
        analise.setAlgoritmo(algoritmoGlobal);

        // When
        analise.executarAlinhamento(sequencia1, sequencia2);

        // Then
        verify(algoritmoGlobal, times(1)).alinharSequencias(sequencia1, sequencia2);
        verify(algoritmoLocal, never()).alinharSequencias(anyString(), anyString());
    }

    @Test
    @DisplayName("Deve executar alinhamento local quando configurado")
    void deveExecutarAlinhamentoLocalQuandoConfigurado() {
        // Given
        String sequencia1 = "ATCGATCG";
        String sequencia2 = "GCTAGCTA";
        analise.setAlgoritmo(algoritmoLocal);

        // When
        analise.executarAlinhamento(sequencia1, sequencia2);

        // Then
        verify(algoritmoLocal, times(1)).alinharSequencias(sequencia1, sequencia2);
        verify(algoritmoGlobal, never()).alinharSequencias(anyString(), anyString());
    }

    @Test
    @DisplayName("Deve permitir troca de algoritmo em tempo de execução")
    void devePermitirTrocaDeAlgoritmoEmTempoDeExecucao() {
        // Given
        String sequencia1 = "ATCGATCG";
        String sequencia2 = "GCTAGCTA";
        analise.setAlgoritmo(algoritmoGlobal);

        // When - Primeira execução com algoritmo global
        analise.executarAlinhamento(sequencia1, sequencia2);

        // Then - Verifica primeira execução
        verify(algoritmoGlobal, times(1)).alinharSequencias(sequencia1, sequencia2);

        // When - Troca para algoritmo local e segunda execução
        analise.setAlgoritmo(algoritmoLocal);
        analise.executarAlinhamento(sequencia1, sequencia2);

        // Then - Verifica segunda execução
        verify(algoritmoLocal, times(1)).alinharSequencias(sequencia1, sequencia2);
    }
}
