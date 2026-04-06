package br.com.webmatte.criacao.abstractFactory.receptor;

import br.com.webmatte.criacao.abstractFactory.interfaces.Receptor;

/**
 * @author atamborim
 */
public class ReceptorMasterCard implements Receptor {

    @Override
    public String recebeBandeiraCartao() {
        System.out.println("Recebendo mensagem do Cartão VISA:");
        String mensagem = "Mensagem Cartão MasterCard";
        return mensagem;
    }
}
