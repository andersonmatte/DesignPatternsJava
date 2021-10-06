package factoryMethody.creator;

import factoryMethody.emissor.EmissorEmail;
import factoryMethody.emissor.EmissorSMS;
import factoryMethody.interfaces.Emissor;

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
