package br.com.webmatte.criacao.factoryMethody.creator;

import br.com.webmatte.criacao.factoryMethody.emissor.EmissorEmail;
import br.com.webmatte.criacao.factoryMethody.emissor.EmissorSMS;
import br.com.webmatte.criacao.factoryMethody.interfaces.Emissor;

/**
 * @author Anderson Matte
 */
public class EmissorCreator {

    public static final int SMS = 0;
    public static final int EMAIL = 1;

    public Emissor criar(int tipoEmissor) {

        if (tipoEmissor == SMS) {
            return new EmissorSMS();
        } else if (tipoEmissor == EMAIL) {
            return new EmissorEmail();
        } else {
            throw new IllegalArgumentException("Tipo de Emissor não encontrado no sistema.");
        }
    }

}
