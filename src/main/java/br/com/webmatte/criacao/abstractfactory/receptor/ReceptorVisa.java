package br.com.webmatte.criacao.abstractfactory.receptor;

import br.com.webmatte.criacao.abstractfactory.interfaces.Receptor;

/**
 * @author Anderson Matte
 */
public class ReceptorVisa implements Receptor {

    @Override
    public String recebeBandeiraCartao() {
        System.out.println("Recebendo mensagem do Cartão VISA:");
        String mensagem = "Mensagem Cartão VISA";
        return mensagem;
    }
}
