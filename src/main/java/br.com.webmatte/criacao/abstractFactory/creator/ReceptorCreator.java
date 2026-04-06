package br.com.webmatte.criacao.abstractFactory.creator;

import br.com.webmatte.criacao.abstractFactory.interfaces.Receptor;
import br.com.webmatte.criacao.abstractFactory.receptor.ReceptorMasterCard;
import br.com.webmatte.criacao.abstractFactory.receptor.ReceptorVisa;

/**
 * @author Anderson Matte
 */
public class ReceptorCreator {

    public static final int VISA = 0;
    public static final int MASTERCARD = 1;

    public Receptor criar(int tipoReceptor) {

        if (tipoReceptor == VISA) {
            return new ReceptorVisa();
        } else if (tipoReceptor == MASTERCARD) {
            return new ReceptorMasterCard();
        } else {
            throw new IllegalArgumentException("Tipo de Emissor não encontrado no sistema.");
        }
    }

}
