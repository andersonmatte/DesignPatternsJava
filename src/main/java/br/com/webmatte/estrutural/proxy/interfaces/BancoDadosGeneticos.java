package br.com.webmatte.estrutural.proxy.interfaces;

/**
 * @author Anderson Matte
 */
public interface BancoDadosGeneticos {

    String buscarSequencia(String codigoAmostra);

    void salvarResultado(String codigoAmostra, String resultado);

    boolean verificarAcesso(String usuario);

}
