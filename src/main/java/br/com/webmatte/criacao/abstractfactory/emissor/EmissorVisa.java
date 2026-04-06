package br.com.webmatte.criacao.abstractfactory.emissor;

import br.com.webmatte.criacao.abstractfactory.interfaces.Emissor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Anderson Matte
 */
@Slf4j
public class EmissorVisa implements Emissor {

    @Override
    public Boolean enviaMensagem(String mensagem) {
        if (mensagem != null) {
            log.info("Enviando Mensagem para o Cartão VISA: ");
            log.info(mensagem);
            return true;
        } else {
            return false;
        }
    }

}
