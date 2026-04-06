package br.com.webmatte.estrutural.proxy;

import br.com.webmatte.estrutural.proxy.control.BancoDadosGeneticosProxy;
import br.com.webmatte.estrutural.proxy.control.BancoDadosGeneticosReal;
import br.com.webmatte.estrutural.proxy.interfaces.BancoDadosGeneticos;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testes do Padrão Proxy - Acesso Controlado a Dados")
class ProxyPatternTest {

    private BancoDadosGeneticos bancoDadosReal;
    private BancoDadosGeneticos proxyAutorizado;
    private BancoDadosGeneticos proxyNaoAutorizado;

    @BeforeEach
    void setUp() {
        bancoDadosReal = new BancoDadosGeneticosReal();
        proxyAutorizado = new BancoDadosGeneticosProxy(bancoDadosReal, "pesquisador");
        proxyNaoAutorizado = new BancoDadosGeneticosProxy(bancoDadosReal, "usuario_invalido");
    }

    @Test
    @DisplayName("Deve permitir acesso para usuário autorizado")
    void devePermitirAcessoParaUsuarioAutorizado() {
        // Given
        String codigoAmostra = "AMOSTRA_001";

        // When & Then
        assertDoesNotThrow(() -> {
            String sequencia = proxyAutorizado.buscarSequencia(codigoAmostra);
            assertNotNull(sequencia);
        });
    }

    @Test
    @DisplayName("Deve bloquear acesso para usuário não autorizado")
    void deveBloquearAcessoParaUsuarioNaoAutorizado() {
        // Given
        String codigoAmostra = "AMOSTRA_001";

        // When & Then
        SecurityException exception = assertThrows(SecurityException.class,
                () -> proxyNaoAutorizado.buscarSequencia(codigoAmostra));

        assertEquals("Acesso não autorizado ao banco de dados genéticos", exception.getMessage());
    }

    @Test
    @DisplayName("Deve permitir salvar dados para usuário autorizado")
    void devePermitirSalvarDadosParaUsuarioAutorizado() {
        // Given
        String codigoAmostra = "AMOSTRA_001";
        String resultado = "ANÁLISE_CONCLUÍDA";

        // When & Then
        assertDoesNotThrow(() -> {
            proxyAutorizado.salvarResultado(codigoAmostra, resultado);
        });
    }

    @Test
    @DisplayName("Deve bloquear salvamento para usuário não autorizado")
    void deveBloquearSalvamentoParaUsuarioNaoAutorizado() {
        // Given
        String codigoAmostra = "AMOSTRA_001";
        String resultado = "ANÁLISE_CONCLUÍDA";

        // When & Then
        SecurityException exception = assertThrows(SecurityException.class,
                () -> proxyNaoAutorizado.salvarResultado(codigoAmostra, resultado));

        assertEquals("Acesso não autorizado para salvar resultados", exception.getMessage());
    }

    @Test
    @DisplayName("Deve delegar chamadas para objeto real quando autorizado")
    void deveDelegarChamadasParaObjetoRealQuandoAutorizado() {
        // Given
        String codigoAmostra = "AMOSTRA_001";

        // When
        String sequenciaProxy = proxyAutorizado.buscarSequencia(codigoAmostra);
        String sequenciaReal = bancoDadosReal.buscarSequencia(codigoAmostra);

        // Then
        assertEquals(sequenciaReal, sequenciaProxy);
    }

    @Test
    @DisplayName("Deve verificar acesso corretamente")
    void deveVerificarAcessoCorretamente() {
        // When & Then
        assertTrue(proxyAutorizado.verificarAcesso("pesquisador"));
        assertTrue(proxyAutorizado.verificarAcesso("analista"));
        assertFalse(proxyNaoAutorizado.verificarAcesso("usuario_invalido"));
    }
}
