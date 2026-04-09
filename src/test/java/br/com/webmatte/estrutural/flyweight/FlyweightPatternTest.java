package br.com.webmatte.estrutural.flyweight;

import br.com.webmatte.estrutural.flyweight.control.AnaliseGenomica;
import br.com.webmatte.estrutural.flyweight.factory.DadoGeneticoFlyweightFactory;
import br.com.webmatte.estrutural.flyweight.interfaces.DadoGeneticoFlyweight;
import br.com.webmatte.estrutural.flyweight.temas.DadoProteina;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testes do Padrão Flyweight - Compartilhamento de Dados")
class FlyweightPatternTest {

    private AnaliseGenomica analise;

    @BeforeEach
    void setUp() {
        analise = new AnaliseGenomica();
    }

    @Test
    @DisplayName("Deve reutilizar instâncias flyweight")
    void deveReutilizarInstanciasFlyweight() {
        // When
        DadoGeneticoFlyweight dado1 = DadoGeneticoFlyweightFactory.getDado(DadoProteina.class);
        DadoGeneticoFlyweight dado2 = DadoGeneticoFlyweightFactory.getDado(DadoProteina.class);
        DadoGeneticoFlyweight dado3 = DadoGeneticoFlyweightFactory.getDado(DadoProteina.class);

        // Then - Todas devem ser a mesma instância
        assertSame(dado1, dado2);
        assertSame(dado2, dado3);
    }

    @Test
    @DisplayName("Deve criar nova instância apenas na primeira chamada")
    void deveCriarNovaInstanciaApenasNaPrimeiraChamada() {
        // When
        DadoGeneticoFlyweight dado1 = DadoGeneticoFlyweightFactory.getDado(DadoProteina.class);
        DadoGeneticoFlyweight dado2 = DadoGeneticoFlyweightFactory.getDado(DadoProteina.class);

        // Then - Apenas uma instância deve ser criada
        assertSame(dado1, dado2);
        assertTrue(dado1 instanceof DadoProteina);
    }

    @Test
    @DisplayName("Deve executar análise com dados compartilhados")
    void deveExecutarAnaliseComDadosCompartilhados() {
        // Given
        String nomeAnalise = "ANALISE_001";

        // When & Then - Não deve lançar exceção
        assertDoesNotThrow(() -> analise.executarAnalise(nomeAnalise));
    }

    @Test
    @DisplayName("Deve compartilhar dados entre múltiplas análises")
    void deveCompartilharDadosEntreMultiplasAnalises() {
        // Given
        AnaliseGenomica analise1 = new AnaliseGenomica();
        AnaliseGenomica analise2 = new AnaliseGenomica();

        // When & Then - Não deve lançar exceções
        assertDoesNotThrow(() -> {
            analise1.executarAnalise("ANALISE_001");
            analise2.executarAnalise("ANALISE_002");
        });
    }

    @Test
    @DisplayName("Deve manter estado intrínseco separado do estado extrínseco")
    void deveManterEstadoIntrinsecoSeparadoDoEstadoExtrinseco() {
        // Given
        DadoGeneticoFlyweight dado = DadoGeneticoFlyweightFactory.getDado(DadoProteina.class);

        // When & Then - Não deve lançar exceção e estado intrínseco deve ser mantido
        assertDoesNotThrow(() -> {
            dado.exibirDado("GENE001", "Contexto1");
            dado.exibirDado("GENE002", "Contexto2");
        });
    }

}
