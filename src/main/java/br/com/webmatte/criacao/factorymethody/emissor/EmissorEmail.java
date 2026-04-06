package br.com.webmatte.criacao.factorymethody.emissor;

import br.com.webmatte.criacao.factorymethody.interfaces.Emissor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Anderson Matte
 */
@Slf4j
public class EmissorEmail implements Emissor {

    public void enviarMensagem(String mensagem) {
        log.info("Enviando Mensagem via Email: ");
        log.info(mensagem);
    }

}
