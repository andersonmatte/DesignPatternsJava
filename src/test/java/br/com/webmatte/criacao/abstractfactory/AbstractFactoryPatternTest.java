package br.com.webmatte.criacao.abstractfactory;

import br.com.webmatte.criacao.abstractfactory.control.EquipamentoLaboratorialFactory;
import br.com.webmatte.criacao.abstractfactory.interfaces.EquipamentoLaboratorial;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testes do Padrão Abstract Factory - Fábrica de Equipamentos")
class AbstractFactoryPatternTest {

    @ParameterizedTest
    @EnumSource(TipoLaboratorio.class)
    @DisplayName("Deve criar equipamentos corretos para cada tipo de laboratório")
    void deveCriarEquipamentosCorretosParaCadaTipoDeLaboratorio(TipoLaboratorio tipoLab) {
        // When
        EquipamentoLaboratorialFactory factory = EquipamentoLaboratorialFactory.getFactory(tipoLab.getTipo());

        // Then
        assertNotNull(factory);

        // When - Cria diferentes tipos de equipamentos
        assertDoesNotThrow(() -> {
            var centrifuga = factory.criarCentrifuga();
            var microscopio = factory.criarMicroscopio();
            var espectrofotometro = factory.criarEspectrofotometro();

            // Verifica que foram criados
            assertNotNull(centrifuga);
            assertNotNull(microscopio);
            assertNotNull(espectrofotometro);
        });
    }

    @Test
    @DisplayName("Deve lançar exceção para tipo de laboratório inválido")
    void deveLancarExcecaoParaTipoDeLaboratorioInvalido() {
        // When & Then
        assertThrows(IllegalArgumentException.class,
                () -> EquipamentoLaboratorialFactory.getFactory("invalido"));
    }

    @Test
    @DisplayName("Deve criar famílias de equipamentos diferentes")
    void deveCriarFamiliasDeEquipamentosDiferentes() {
        // When
        var factoryGenetica = EquipamentoLaboratorialFactory.getFactory("genetica");
        var factoryBioquimica = EquipamentoLaboratorialFactory.getFactory("bioquimica");

        // Then
        var centrifugaGenetica = factoryGenetica.criarCentrifuga();
        var centrifugaBioquimica = factoryBioquimica.criarCentrifuga();

        // Devem ser diferentes
        assertNotSame(centrifugaGenetica, centrifugaBioquimica);
        assertTrue(centrifugaGenetica.toString().toLowerCase().contains("genetica"));
        assertTrue(centrifugaBioquimica.toString().toLowerCase().contains("bioquimica"));
    }

    @Test
    @DisplayName("Deve manter consistência dentro da mesma família")
    void deveManterConsistenciaDentroDaMesmaFamilia() {
        // Given
        var factory = EquipamentoLaboratorialFactory.getFactory("molecular");

        // When
        var centrifuga = factory.criarCentrifuga();
        var microscopio = factory.criarMicroscopio();
        var espectrofotometro = factory.criarEspectrofotometro();

        // Then - Todos devem ser do mesmo tipo de laboratório
        String centrifugaStr = centrifuga.toString();
        String microscopioStr = microscopio.toString();
        String espectrofotometroStr = espectrofotometro.toString();

        assertTrue(centrifugaStr.toLowerCase().contains("molecular"));
        assertTrue(microscopioStr.toLowerCase().contains("molecular"));
        assertTrue(espectrofotometroStr.toLowerCase().contains("molecular"));
    }

    @Test
    @DisplayName("Deve suportar criação em massa")
    void deveSuportarCriacaoEmMassa() {
        // Given
        var factory = EquipamentoLaboratorialFactory.getFactory("genetica");

        // When - Cria múltiplos equipamentos
        var equipamentos = new java.util.ArrayList<EquipamentoLaboratorial>();
        for (int i = 0; i < 10; i++) {
            equipamentos.add(factory.criarCentrifuga());
        }

        // Then
        assertEquals(10, equipamentos.size());
        equipamentos.forEach(equipamento ->
                assertTrue(equipamento.toString().toLowerCase().contains("genetica")));
    }

    enum TipoLaboratorio {
        GENETICA("genetica"),
        BIOQUIMICA("bioquimica"),
        MOLECULAR("molecular");

        private final String tipo;

        TipoLaboratorio(String tipo) {
            this.tipo = tipo;
        }

        public String getTipo() {
            return tipo;
        }
    }
}
