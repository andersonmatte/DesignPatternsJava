package br.com.webmatte.criacao.prototype;

import br.com.webmatte.criacao.prototype.entity.AmostraBiologica;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testes do Padrão Prototype - Clonagem de Amostras")
class PrototypePatternTest {

    private AmostraBiologica amostraOriginal;

    @BeforeEach
    void setUp() {
        amostraOriginal = new AmostraBiologica(
                "AMOSTRA_001",
                "Sangue",
                "João Silva",
                "2024-01-15"
        );
    }

    @Test
    @DisplayName("Deve criar clone exato da amostra")
    void deveCriarCloneExatoDaAmostra() {
        // When
        AmostraBiologica clone = amostraOriginal.copy();

        // Then
        assertNotNull(clone);
        assertEquals(amostraOriginal.getCodigo(), clone.getCodigo());
        assertEquals(amostraOriginal.getTipo(), clone.getTipo());
        assertEquals(amostraOriginal.getPaciente(), clone.getPaciente());
        assertEquals(amostraOriginal.getDataColeta(), clone.getDataColeta());
    }

    @Test
    @DisplayName("Deve criar instâncias independentes")
    void deveCriarInstanciasIndependentes() {
        // When
        AmostraBiologica clone = amostraOriginal.copy();

        // When - Modifica o clone
        clone.setPaciente("Maria Santos");

        // Then - Original não deve ser afetado
        assertEquals("João Silva", amostraOriginal.getPaciente());
        assertEquals("Maria Santos", clone.getPaciente());
        assertNotSame(amostraOriginal, clone);
    }

    @Test
    @DisplayName("Deve suportar múltiplos clones")
    void deveSuportarMultiplosClones() {
        // When
        AmostraBiologica clone1 = amostraOriginal.copy();
        AmostraBiologica clone2 = amostraOriginal.copy();
        AmostraBiologica clone3 = amostraOriginal.copy();

        // Then
        assertEquals(amostraOriginal.getCodigo(), clone1.getCodigo());
        assertEquals(amostraOriginal.getCodigo(), clone2.getCodigo());
        assertEquals(amostraOriginal.getCodigo(), clone3.getCodigo());

        assertNotSame(clone1, clone2);
        assertNotSame(clone2, clone3);
        assertNotSame(clone1, clone3);
    }

    @Test
    @DisplayName("Deve manter estado original após modificações no clone")
    void deveManterEstadoOriginalAposModificacoesNoClone() {
        // Given
        AmostraBiologica clone = amostraOriginal.copy();

        // When - Modificações extensivas no clone
        clone.setCodigo("CLONE_001");
        clone.setTipo("Saliva");
        clone.setPaciente("Paciente Clone");
        clone.setDataColeta("2024-02-15");

        // Then - Original deve permanecer inalterado
        assertEquals("AMOSTRA_001", amostraOriginal.getCodigo());
        assertEquals("Sangue", amostraOriginal.getTipo());
        assertEquals("João Silva", amostraOriginal.getPaciente());
        assertEquals("2024-01-15", amostraOriginal.getDataColeta());
    }

    @Test
    @DisplayName("Deve funcionar como factory de clones")
    void deveFuncionarComoFactoryDeClones() {
        // When
        AmostraBiologica clone1 = amostraOriginal.copy();
        AmostraBiologica clone2 = amostraOriginal.copy();

        // Then - Ambos devem ser clones válidos
        assertNotNull(clone1);
        assertNotNull(clone2);
        assertEquals(amostraOriginal.getCodigo(), clone1.getCodigo());
        assertEquals(amostraOriginal.getCodigo(), clone2.getCodigo());
    }
}
