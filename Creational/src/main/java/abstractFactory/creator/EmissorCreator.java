package abstractFactory.creator;

import abstractFactory.emissor.EmissorMasterCard;
import abstractFactory.emissor.EmissorVisa;
import abstractFactory.interfaces.Emissor;

/**
 * @author Anderson Matte
 */
public class EmissorCreator {

    public static final int VISA = 0;
    public static final int MASTERCARD = 1;

    public Emissor criar(int tipoEmissor) {

        if (tipoEmissor == VISA) {
            return new EmissorVisa();
        } else if (tipoEmissor == MASTERCARD) {
            return new EmissorMasterCard();
        } else {
            throw new IllegalArgumentException("Tipo de Emissor não encontrado no sistema.");
        }
    }

}
