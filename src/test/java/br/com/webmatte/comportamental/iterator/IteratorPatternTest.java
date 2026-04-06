package br.com.webmatte.comportamental.iterator;

import br.com.webmatte.comportamental.iterator.control.SequenciaGenetica;
import br.com.webmatte.comportamental.iterator.interfaces.Iterator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testes do Padrão Iterator - Sequências Genéticas")
class IteratorPatternTest {

    private SequenciaGenetica sequenciaGenetica;

    @BeforeEach
    void setUp() {
        sequenciaGenetica = new SequenciaGenetica();
        sequenciaGenetica.adicionarGene("GENE001");
        sequenciaGenetica.adicionarGene("GENE002");
        sequenciaGenetica.adicionarGene("GENE003");
    }

    @Test
    @DisplayName("Deve iterar sobre todos os genes da sequência")
    void deveIterarSobreTodosOsGenes() {
        // Given
        Iterator<String> iterator = sequenciaGenetica.criarIterator();

        // When & Then
        assertTrue(iterator.hasNext());
        assertEquals("GENE001", iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals("GENE002", iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals("GENE003", iterator.next());
        assertFalse(iterator.hasNext());
    }

    @Test
    @DisplayName("Deve lançar exceção quando não houver mais elementos")
    void deveLancarExcecaoQuandoNaoHouverMaisElementos() {
        // Given
        Iterator<String> iterator = sequenciaGenetica.criarIterator();

        // Consome todos os elementos
        while (iterator.hasNext()) {
            iterator.next();
        }

        // When & Then
        assertThrows(NoSuchElementException.class, iterator::next);
    }

    @Test
    @DisplayName("Deve funcionar com sequência vazia")
    void deveFuncionarComSequenciaVazia() {
        // Given
        SequenciaGenetica sequenciaVazia = new SequenciaGenetica();
        Iterator<String> iterator = sequenciaVazia.criarIterator();

        // When & Then
        assertFalse(iterator.hasNext());
        assertThrows(NoSuchElementException.class, iterator::next);
    }

    @Test
    @DisplayName("Deve criar iteradores independentes")
    void deveCriarIteradoresIndependentes() {
        // Given
        Iterator<String> iterator1 = sequenciaGenetica.criarIterator();
        Iterator<String> iterator2 = sequenciaGenetica.criarIterator();

        // When
        iterator1.next(); // Avança primeiro iterador

        // Then
        assertEquals("GENE001", iterator2.next()); // Segundo iterador deve começar do início
    }
}
