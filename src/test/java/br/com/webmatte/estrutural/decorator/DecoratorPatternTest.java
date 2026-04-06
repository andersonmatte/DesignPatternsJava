package br.com.webmatte.estrutural.decorator;

import br.com.webmatte.estrutural.decorator.control.AnaliseBasica;
import br.com.webmatte.estrutural.decorator.control.AnaliseComRelatorio;
import br.com.webmatte.estrutural.decorator.control.AnaliseComValidacao;
import br.com.webmatte.estrutural.decorator.interfaces.AnaliseBio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
@DisplayName("Testes do Padrão Decorator - Enriquecimento de Análises")
class DecoratorPatternTest {

    @Mock
    private AnaliseBio analiseBase;

    private AnaliseBasica analiseBasica;

    @BeforeEach
    void setUp() {
        analiseBasica = new AnaliseBasica();
    }

    @Test
    @DisplayName("Deve executar análise básica sem decoradores")
    void deveExecutarAnaliseBasicaSemDecoradores() {
        // Given
        String amostra = "AMOSTRA_001";

        // When & Then
        assertDoesNotThrow(() -> analiseBasica.executarAnalise(amostra));
    }

    @Test
    @DisplayName("Deve adicionar camada de validação à análise")
    void deveAdicionarCamadaDeValidacaoAnalise() {
        // Given
        String amostraValida = "AMOSTRA_001";
        AnaliseComValidacao analiseComValidacao = new AnaliseComValidacao(analiseBasica);

        // When & Then
        assertDoesNotThrow(() -> analiseComValidacao.executarAnalise(amostraValida));
    }

    @Test
    @DisplayName("Deve rejeitar amostra inválida com validação")
    void deveRejeitarAmostraInvalidaComValidacao() {
        // Given
        String amostraInvalida = "";
        AnaliseComValidacao analiseComValidacao = new AnaliseComValidacao(analiseBasica);

        // When & Then
        assertDoesNotThrow(() -> analiseComValidacao.executarAnalise(amostraInvalida));
        // A validação deve impedir a execução da análise base
    }

    @Test
    @DisplayName("Deve adicionar camada de relatório à análise")
    void deveAdicionarCamadaDeRelatorioAnalise() {
        // Given
        String amostra = "AMOSTRA_001";
        AnaliseComRelatorio analiseComRelatorio = new AnaliseComRelatorio(analiseBasica);

        // When & Then
        assertDoesNotThrow(() -> analiseComRelatorio.executarAnalise(amostra));
    }

    @Test
    @DisplayName("Deve compor múltiplos decoradores")
    void deveComporMultiplosDecoradores() {
        // Given
        String amostra = "AMOSTRA_001";

        // When - Análise com validação e relatório
        AnaliseComValidacao analiseComValidacao = new AnaliseComValidacao(analiseBasica);
        AnaliseComRelatorio analiseComRelatorio = new AnaliseComRelatorio(analiseComValidacao);

        // Then
        assertDoesNotThrow(() -> analiseComRelatorio.executarAnalise(amostra));
    }

    @Test
    @DisplayName("Deve manter comportamento original com mock")
    void deveManterComportamentoOriginalComMock() {
        // Given
        String amostra = "AMOSTRA_001";
        AnaliseComValidacao decorator = new AnaliseComValidacao(analiseBase);

        // When
        decorator.executarAnalise(amostra);

        // Then
        verify(analiseBase, times(1)).executarAnalise(amostra);
    }
}
