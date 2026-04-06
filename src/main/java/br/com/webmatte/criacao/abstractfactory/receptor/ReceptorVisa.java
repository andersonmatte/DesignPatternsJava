package br.com.webmatte.criacao.abstractfactory.receptor;

import br.com.webmatte.criacao.abstractfactory.interfaces.Receptor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Anderson Matte
 */
@Slf4j
public class ReceptorVisa implements Receptor {

    @Override
    public String recebeBandeiraCartao() {
        log.info("Recebendo mensagem do Cartão VISA:");
        return "Mensagem Cartão VISA";
    }
}
