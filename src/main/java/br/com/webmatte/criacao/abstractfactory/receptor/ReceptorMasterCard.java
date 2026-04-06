package br.com.webmatte.criacao.abstractfactory.receptor;

import br.com.webmatte.criacao.abstractfactory.interfaces.Receptor;

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
