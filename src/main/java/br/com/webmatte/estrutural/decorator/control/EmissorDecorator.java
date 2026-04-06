package br.com.webmatte.estrutural.decorator.control;

import br.com.webmatte.estrutural.decorator.interfaces.Emissor;

/**
 * @author Anderson Matte
 */
public class EmissorDecorator implements Emissor {

    private Emissor emissor;

    public EmissorDecorator(Emissor emissor) {
        this.emissor = emissor;
    }

    @Override
    public void envia(String mensagem) {
        // document why this method is empty
    }

    public Emissor getEmissor() {
        return this.emissor;
    }

}
