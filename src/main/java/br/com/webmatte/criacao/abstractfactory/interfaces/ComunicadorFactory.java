package br.com.webmatte.criacao.abstractfactory.interfaces;

/**
 * @author Anderson Matte
 */
public interface ComunicadorFactory {

    Emissor createEmissor();

    Receptor createRceptor();

}
