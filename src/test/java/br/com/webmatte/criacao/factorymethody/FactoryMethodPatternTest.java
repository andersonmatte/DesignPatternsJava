package br.com.webmatte.criacao.factorymethody;

import br.com.webmatte.criacao.factorymethody.creator.CulturaCelularCreator;
import br.com.webmatte.criacao.factorymethody.emissor.CulturaBacteriana;
import br.com.webmatte.criacao.factorymethody.emissor.CulturaCelularAnimal;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testes do Padrão Factory Method - Culturas Celulares")
class FactoryMethodPatternTest {

    @ParameterizedTest
    @EnumSource(TipoCultura.class)
    @DisplayName("Deve criar tipo correto de cultura celular")
    void deveCriarTipoCorretoDeCulturaCelular(TipoCultura tipoCultura) {
        // When
        var cultura = CulturaCelularCreator.criarCultura(tipoCultura.getTipo());

        // Then
        assertNotNull(cultura);

        switch (tipoCultura) {
            case BACTERIANA:
                assertInstanceOf(CulturaBacteriana.class, cultura);
                break;
            case ANIMAL:
                assertInstanceOf(CulturaCelularAnimal.class, cultura);
                break;
        }
    }

    @Test
    @DisplayName("Deve lançar exceção para tipo de cultura inválido")
    void deveLancarExcecaoParaTipoDeCulturaInvalido() {
        // When & Then
        assertThrows(IllegalArgumentException.class,
                () -> CulturaCelularCreator.criarCultura("invalido"));
    }

    @Test
    @DisplayName("Deve criar múltiplas culturas do mesmo tipo")
    void deveCriarMultiplasCulturasDoMesmoTipo() {
        // When
        var cultura1 = CulturaCelularCreator.criarCultura("bacteriana");
        var cultura2 = CulturaCelularCreator.criarCultura("bacteriana");
        var cultura3 = CulturaCelularCreator.criarCultura("bacteriana");

        // Then
        assertNotNull(cultura1);
        assertNotNull(cultura2);
        assertNotNull(cultura3);

        // Todas devem ser do mesmo tipo
        assertInstanceOf(CulturaBacteriana.class, cultura1);
        assertInstanceOf(CulturaBacteriana.class, cultura2);
        assertInstanceOf(CulturaBacteriana.class, cultura3);

        // Mas devem ser instâncias diferentes
        assertNotSame(cultura1, cultura2);
        assertNotSame(cultura2, cultura3);
    }

    enum TipoCultura {
        BACTERIANA("bacteriana"),
        ANIMAL("animal");

        private final String tipo;

        TipoCultura(String tipo) {
            this.tipo = tipo;
        }

        public String getTipo() {
            return tipo;
        }
    }
}
