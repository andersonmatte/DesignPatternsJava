package br.com.webmatte.estrutural.composite;

import br.com.webmatte.estrutural.composite.control.Gene;
import br.com.webmatte.estrutural.composite.control.Nucleotideo;
import br.com.webmatte.estrutural.composite.control.SequenciaComposta;
import br.com.webmatte.estrutural.composite.interfaces.ComponenteSequencia;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Testes do Padrão Composite - Estrutura de Sequências")
class CompositePatternTest {

    private ComponenteSequencia nucleotideoA;
    private ComponenteSequencia nucleotideoT;
    private ComponenteSequencia nucleotideoC;
    private ComponenteSequencia nucleotideoG;

    @BeforeEach
    void setUp() {
        nucleotideoA = new Nucleotideo("A", "1");
        nucleotideoT = new Nucleotideo("T", "2");
        nucleotideoC = new Nucleotideo("C", "3");
        nucleotideoG = new Nucleotideo("G", "4");
    }

    @Test
    @DisplayName("Deve calcular tamanho corretamente para nucleotideos individuais")
    void deveCalcularTamanhoCorretamenteParaNucleotideosIndividuais() {
        // When & Then
        assertEquals(1, nucleotideoA.getTamanho());
        assertEquals(1, nucleotideoT.getTamanho());
        assertEquals(1, nucleotideoC.getTamanho());
        assertEquals(1, nucleotideoG.getTamanho());
    }

    @Test
    @DisplayName("Deve criar sequência composta com múltiplos componentes")
    void deveCriarSequenciaCompostaComMultiplosComponentes() {
        // Given
        SequenciaComposta sequencia = new SequenciaComposta();

        // When
        sequencia.adicionar(nucleotideoA);
        sequencia.adicionar(nucleotideoT);
        sequencia.adicionar(nucleotideoC);

        // Then
        assertEquals(3, sequencia.getTamanho());
    }

    @Test
    @DisplayName("Deve suportar estrutura aninhada de componentes")
    void deveSuportarEstruturaAninhadaDeComponentes() {
        // Given
        SequenciaComposta sequenciaInterna = new SequenciaComposta();
        sequenciaInterna.adicionar(nucleotideoA);
        sequenciaInterna.adicionar(nucleotideoT);

        SequenciaComposta sequenciaExterna = new SequenciaComposta();
        sequenciaExterna.adicionar(sequenciaInterna);
        sequenciaExterna.adicionar(nucleotideoC);
        sequenciaExterna.adicionar(nucleotideoG);

        // When & Then
        assertEquals(4, sequenciaExterna.getTamanho());
    }

    @Test
    @DisplayName("Deve tratar componentes simples e compostos uniformemente")
    void deveTratarComponentesSimplesECompostosUniformemente() {
        // Given
        ComponenteSequencia gene = new Gene("GENE001", "ATCG");
        ComponenteSequencia nucleotideo = new Nucleotideo("G", "5");
        SequenciaComposta sequencia = new SequenciaComposta();

        // When
        sequencia.adicionar(gene);
        sequencia.adicionar(nucleotideo);

        // Then - Todos devem implementar a mesma interface
        assertDoesNotThrow(() -> {
            sequencia.exibirSequencia();
            gene.exibirSequencia();
            nucleotideo.exibirSequencia();
        });

        assertEquals(5, sequencia.getTamanho()); // 4 (gene) + 1 (nucleotideo)
    }

    @Test
    @DisplayName("Deve permitir remoção de componentes da sequência")
    void devePermitirRemocaoDeComponentesDaSequencia() {
        // Given
        SequenciaComposta sequencia = new SequenciaComposta();
        sequencia.adicionar(nucleotideoA);
        sequencia.adicionar(nucleotideoT);
        sequencia.adicionar(nucleotideoC);

        assertEquals(3, sequencia.getTamanho());

        // When
        sequencia.remover(nucleotideoT);

        // Then
        assertEquals(2, sequencia.getTamanho());
    }
}
