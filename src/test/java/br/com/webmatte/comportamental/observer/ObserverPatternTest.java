package br.com.webmatte.comportamental.observer;

import br.com.webmatte.comportamental.observer.control.Gene;
import br.com.webmatte.comportamental.observer.control.LaboratorioPesquisa;
import br.com.webmatte.comportamental.observer.observer.AnalistaGenetico;
import br.com.webmatte.comportamental.observer.observer.SistemaAlerta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testes do Padrão Observer - Observação de Mutações")
class ObserverPatternTest {

    private Gene gene;
    private LaboratorioPesquisa laboratorio;
    private SistemaAlerta sistemaAlerta;
    private AnalistaGenetico analista;

    @BeforeEach
    void setUp() {
        gene = new Gene("GENE_BRCA1");
        laboratorio = new LaboratorioPesquisa("Lab Central");
        sistemaAlerta = new SistemaAlerta();
        analista = new AnalistaGenetico("Dr. Silva");
    }

    @Test
    @DisplayName("Deve notificar observadores quando mutação detectada")
    void deveNotificarObservadoresQuandoMutacaoDetectada() {
        // Given
        gene.adicionarObservador(laboratorio);
        gene.adicionarObservador(sistemaAlerta);
        gene.adicionarObservador(analista);

        assertEquals(3, gene.getTotalObservadores());

        // When
        gene.detectarMutacao("MUTAÇÃO_001", "Posição 1234");

        // Then
        assertTrue(laboratorio.isNotificado());
        assertTrue(sistemaAlerta.isNotificado());
        assertTrue(analista.isNotificado());
    }

    @Test
    @DisplayName("Deve remover observador corretamente")
    void deveRemoverObservadorCorretamente() {
        // Given
        gene.adicionarObservador(laboratorio);
        gene.adicionarObservador(sistemaAlerta);
        assertEquals(2, gene.getTotalObservadores());

        // When
        gene.removerObservador(laboratorio);

        // Then
        assertEquals(1, gene.getTotalObservadores());
        gene.detectarMutacao("MUTAÇÃO_001", "Posição 1234");

        assertTrue(sistemaAlerta.isNotificado());
        assertFalse(laboratorio.isNotificado());
    }

    @Test
    @DisplayName("Deve funcionar sem observadores")
    void deveFuncionarSemObservadores() {
        // Given - Sem observadores
        assertEquals(0, gene.getTotalObservadores());

        // When & Then - Não deve lançar exceção
        assertDoesNotThrow(() -> {
            gene.detectarMutacao("MUTAÇÃO_001", "Posição 1234");
        });
    }

    @Test
    @DisplayName("Deve notificar múltiplas mutações")
    void deveNotificarMultiplasMutacoes() {
        // Given
        gene.adicionarObservador(laboratorio);
        gene.adicionarObservador(analista);

        // When
        gene.detectarMutacao("MUTAÇÃO_001", "Posição 1234");
        gene.detectarMutacao("MUTAÇÃO_002", "Posição 5678");
        gene.detectarMutacao("MUTAÇÃO_003", "Posição 9012");

        // Then
        assertEquals(3, laboratorio.getTotalNotificacoes());
        assertEquals(3, analista.getTotalNotificacoes());
    }

    @Test
    @DisplayName("Deve manter dados da mutação")
    void deveManterDadosDaMutacao() {
        // Given
        gene.adicionarObservador(laboratorio);

        String tipoMutacao = "MUTAÇÃO_PONTO";
        String posicao = "CROMOSSOMO 17";

        // When
        gene.detectarMutacao(tipoMutacao, posicao);

        // Then
        assertEquals(tipoMutacao, gene.getUltimaMutacao().getTipo());
        assertEquals(posicao, gene.getUltimaMutacao().getPosicao());
        assertTrue(laboratorio.getUltimaNotificacao().contains(tipoMutacao));
        assertTrue(laboratorio.getUltimaNotificacao().contains(posicao));
    }

    @Test
    @DisplayName("Deve suportar múltiplos observadores do mesmo tipo")
    void deveSuportarMultiplasObservadoresDoMesmoTipo() {
        // Given
        AnalistaGenetico analista1 = new AnalistaGenetico("Dr. Silva");
        AnalistaGenetico analista2 = new AnalistaGenetico("Dr. Santos");
        AnalistaGenetico analista3 = new AnalistaGenetico("Dr. Oliveira");

        gene.adicionarObservador(analista1);
        gene.adicionarObservador(analista2);
        gene.adicionarObservador(analista3);

        // When
        gene.detectarMutacao("MUTAÇÃO_001", "Posição 1234");

        // Then
        assertTrue(analista1.isNotificado());
        assertTrue(analista2.isNotificado());
        assertTrue(analista3.isNotificado());
    }
}
