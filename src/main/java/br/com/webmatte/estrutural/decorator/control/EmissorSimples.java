package br.com.webmatte.estrutural.decorator.control;

import br.com.webmatte.estrutural.decorator.interfaces.Emissor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Anderson Matte
 */
public class EmissorSimples implements Emissor {

    private static final Logger log = LoggerFactory.getLogger(EmissorSimples.class);

    @Override
    public void envia(String mensagem) {
        log.info("Enviando a mensagem: ");
        log.info(mensagem);
    }

}
