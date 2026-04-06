package br.com.webmatte.estrutural.adapter;

import br.com.webmatte.estrutural.adapter.adaptador.AnalisadorAdapter;
import br.com.webmatte.estrutural.adapter.control.AnalisadorSequencias;
import br.com.webmatte.estrutural.adapter.control.AnalisadorUnificado;
import br.com.webmatte.estrutural.adapter.entity.AmostraBio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("Testes do Padrão Adapter - Compatibilidade de Formatos")
class AdapterPatternTest {

    @Mock
    private AnalisadorUnificado analisadorUnificado;

    private AnalisadorAdapter adapter;
    private AmostraBio amostra;

    @BeforeEach
    void setUp() {
        adapter = new AnalisadorAdapter(analisadorUnificado);
        amostra = new AmostraBio("AMOSTRA_001", "ATCGATCGATCGATCG");
    }

    @Test
    @DisplayName("Deve adaptar análise FASTA para formato unificado")
    void deveAdaptarAnaliseFASTAParaFormatoUnificado() {
        // When
        adapter.analisarFASTA(amostra);

        // Then
        verify(analisadorUnificado, times(1)).analisar(amostra, "FASTA");
    }

    @Test
    @DisplayName("Deve adaptar análise GenBank para formato unificado")
    void deveAdaptarAnaliseGenBankParaFormatoUnificado() {
        // When
        adapter.analisarGenBank(amostra);

        // Then
        verify(analisadorUnificado, times(1)).analisar(amostra, "GENBANK");
    }

    @Test
    @DisplayName("Deve manter interface original para clientes existentes")
    void deveManterInterfaceOriginalParaClientesExistentes() {
        // Given - Cliente que usa a interface antiga
        AnalisadorSequencias analisadorAntigo = adapter;

        // When & Then - Deve funcionar sem problemas
        assertDoesNotThrow(() -> {
            analisadorAntigo.analisarFASTA(amostra);
            analisadorAntigo.analisarGenBank(amostra);
        });

        verify(analisadorUnificado, times(1)).analisar(amostra, "FASTA");
        verify(analisadorUnificado, times(1)).analisar(amostra, "GENBANK");
    }

    @Test
    @DisplayName("Deve processar múltiplas amostras com diferentes formatos")
    void deveProcessarMultiplasAmostrasComDiferentesFormatos() {
        // Given
        AmostraBio amostra1 = new AmostraBio("AMOSTRA_001", "ATCGATCG");
        AmostraBio amostra2 = new AmostraBio("AMOSTRA_002", "GCTAGCTA");
        AmostraBio amostra3 = new AmostraBio("AMOSTRA_003", "TTAGGCTT");

        // When
        adapter.analisarFASTA(amostra1);
        adapter.analisarGenBank(amostra2);
        adapter.analisarFASTA(amostra3);

        // Then
        verify(analisadorUnificado, times(2)).analisar(any(AmostraBio.class), eq("FASTA"));
        verify(analisadorUnificado, times(1)).analisar(any(AmostraBio.class), eq("GENBANK"));
    }
}
