package br.com.webmatte.estrutural.decorator.control;

import br.com.webmatte.estrutural.decorator.interfaces.Emissor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Anderson Matte
 */
@Slf4j
public class EmissorDecoratorCriptografia extends EmissorDecorator {

    public EmissorDecoratorCriptografia(Emissor emissor) {
        super(emissor);
    }

    public void envia(String mensagem) {
        log.info("Enviando mensagem com criptografia ");
        this.getEmissor().envia(criptograva(mensagem));
    }

    private String criptograva(String mensagem) {
        return new StringBuilder(mensagem).reverse().toString();
    }

}
