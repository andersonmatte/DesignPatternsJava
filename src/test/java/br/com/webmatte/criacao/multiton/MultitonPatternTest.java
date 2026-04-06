package br.com.webmatte.criacao.multiton.test;

import br.com.webmatte.criacao.multiton.TipoSanguineo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testes do Padrão Multiton - Tipos Sanguíneos")
class MultitonPatternTest {

    @ParameterizedTest
    @EnumSource(TipoSanguineoTest.class)
    @DisplayName("Deve retornar mesma instância para mesmo tipo sanguíneo")
    void deveRetornarMesmaInstanciaParaMesmoTipoSanguineo(TipoSanguineoTest tipoTest) {
        // When
        TipoSanguineo instancia1 = TipoSanguineo.getInstance(tipoTest.getTipo());
        TipoSanguineo instancia2 = TipoSanguineo.getInstance(tipoTest.getTipo());
        TipoSanguineo instancia3 = TipoSanguineo.getInstance(tipoTest.getTipo());

        // Then
        assertSame(instancia1, instancia2);
        assertSame(instancia2, instancia3);
        assertEquals(tipoTest.getTipo(), instancia1.getTipo());
    }

    @Test
    @DisplayName("Deve retornar instâncias diferentes para tipos diferentes")
    void deveRetornarInstanciasDiferentesParaTiposDiferentes() {
        // When
        TipoSanguineo tipoA = TipoSanguineo.getInstance("A+");
        TipoSanguineo tipoB = TipoSanguineo.getInstance("B-");
        TipoSanguineo tipoO = TipoSanguineo.getInstance("O+");

        // Then
        assertNotSame(tipoA, tipoB);
        assertNotSame(tipoB, tipoO);
        assertNotSame(tipoA, tipoO);

        assertEquals("A+", tipoA.getTipo());
        assertEquals("B-", tipoB.getTipo());
        assertEquals("O+", tipoO.getTipo());
    }

    @Test
    @DisplayName("Deve inicializar fator Rh corretamente")
    void deveInicializarFatorRhCorretamente() {
        // When & Then
        assertTrue(TipoSanguineo.getInstance("A+").isPositivo());
        assertTrue(TipoSanguineo.getInstance("B+").isPositivo());
        assertFalse(TipoSanguineo.getInstance("A-").isPositivo());
        assertFalse(TipoSanguineo.getInstance("O-").isPositivo());
    }

    @Test
    @DisplayName("Deve lançar exceção para tipo sanguíneo inválido")
    void deveLancarExcecaoParaTipoSanguineoInvalido() {
        // When & Then
        assertThrows(IllegalArgumentException.class,
                () -> TipoSanguineo.getInstance("XYZ"));
    }

    @Test
    @DisplayName("Deve manter estado entre diferentes acessos")
    void deveManterEstadoEntreDiferentesAcessos() {
        // Given
        TipoSanguineo instancia1 = TipoSanguineo.getInstance("A+");
        TipoSanguineo instancia2 = TipoSanguineo.getInstance("A+");

        // When - Modifica através de uma referência
        instancia1.setInformacao("Informação atualizada");

        // Then - Deve refletir na outra referência
        assertEquals("Informação atualizada", instancia2.getInformacao());
    }

    @Test
    @DisplayName("Deve gerenciar pool de instâncias corretamente")
    void deveGerenciarPoolDeInstanciasCorretamente() {
        // When - Cria múltiplas instâncias
        int totalInstancias = 8;
        for (int i = 0; i < totalInstancias; i++) {
            TipoSanguineo.getInstance("A+");
            TipoSanguineo.getInstance("B-");
        }

        // Then - Deve ter apenas 8 instâncias no pool
        assertEquals(totalInstancias, TipoSanguineo.getTotalInstancias());
    }

    enum TipoSanguineoTest {
        A_POSITIVO("A+"),
        A_NEGATIVO("A-"),
        B_POSITIVO("B+"),
        B_NEGATIVO("B-"),
        O_POSITIVO("O+"),
        O_NEGATIVO("O-"),
        AB_POSITIVO("AB+"),
        AB_NEGATIVO("AB-");

        private final String tipo;

        TipoSanguineoTest(String tipo) {
            this.tipo = tipo;
        }

        public String getTipo() {
            return tipo;
        }
    }
}
