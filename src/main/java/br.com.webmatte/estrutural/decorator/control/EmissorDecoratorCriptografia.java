package br.com.webmatte.estrutural.decorator.control;

import br.com.webmatte.estrutural.decorator.interfaces.Emissor;

/**
 * @author Anderson Matte
 */
public class EmissorDecoratorCriptografia extends EmissorDecorator {

    public EmissorDecoratorCriptografia(Emissor emissor) {
        super(emissor);
    }

    public void envia(String mensagem) {
        System.out.println("Enviando mensagem com criptografia ");
        this.getEmissor().envia(criptograva(mensagem));
    }

    private String criptograva(String mensagem) {
        return new StringBuilder(mensagem).reverse().toString();
    }

}
