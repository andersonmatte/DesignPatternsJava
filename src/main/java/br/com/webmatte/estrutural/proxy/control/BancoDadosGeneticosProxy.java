package br.com.webmatte.estrutural.proxy.control;

import br.com.webmatte.estrutural.proxy.interfaces.BancoDadosGeneticos;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Anderson Matte
 */
@Slf4j
public class BancoDadosGeneticosProxy implements BancoDadosGeneticos {

    private BancoDadosGeneticos bancoDadosReal;
    private String usuarioAtual;

    public BancoDadosGeneticosProxy(BancoDadosGeneticos bancoDadosReal, String usuario) {
        this.bancoDadosReal = bancoDadosReal;
        this.usuarioAtual = usuario;
    }

    @Override
    public String buscarSequencia(String codigoAmostra) {
        log.info("=== PROXY - CONTROLE DE ACESSO ===");
        log.info("Usuário solicitante: {}", usuarioAtual);

        // Verificação de segurança
        if (!bancoDadosReal.verificarAcesso(usuarioAtual)) {
            log.error("ACESSO NEGADO! Usuário {} não autorizado", usuarioAtual);
            throw new SecurityException("Acesso não autorizado ao banco de dados genéticos");
        }

        log.info("Acesso autorizado. Buscando sequência...");
        String sequencia = bancoDadosReal.buscarSequencia(codigoAmostra);
        log.info("Sequência recuperada com sucesso via proxy");
        return sequencia;
    }

    @Override
    public void salvarResultado(String codigoAmostra, String resultado) {
        log.info("=== PROXY - CONTROLE DE ACESSO ===");
        log.info("Usuário solicitante: {}", usuarioAtual);

        // Verificação de segurança
        if (!bancoDadosReal.verificarAcesso(usuarioAtual)) {
            log.error("ACESSO NEGADO! Usuário {} não autorizado para salvar", usuarioAtual);
            throw new SecurityException("Acesso não autorizado para salvar resultados");
        }

        log.info("Acesso autorizado. Salvando resultado...");
        bancoDadosReal.salvarResultado(codigoAmostra, resultado);
        log.info("Resultado salvo com sucesso via proxy");
    }

    @Override
    public boolean verificarAcesso(String usuario) {
        log.info("Proxy verificando acesso para usuário: {}", usuario);
        return bancoDadosReal.verificarAcesso(usuario);
    }

}
