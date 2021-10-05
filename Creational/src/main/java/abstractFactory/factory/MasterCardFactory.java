package abstractFactory.factory;

import abstractFactory.creator.EmissorCreator;
import abstractFactory.creator.ReceptorCreator;
import abstractFactory.interfaces.ComunicadorFactory;
import abstractFactory.interfaces.Emissor;
import abstractFactory.interfaces.Receptor;

/**
 * @author Anderson Matte
 */
public class MasterCardFactory implements ComunicadorFactory {

    private EmissorCreator emissorCreator = new EmissorCreator();
    private ReceptorCreator receptorCreator = new ReceptorCreator();

    @Override
    public Emissor createEmissor() {
        return emissorCreator.criar(EmissorCreator.MASTERCARD);
    }

    @Override
    public Receptor createRceptor() {
        return receptorCreator.criar(ReceptorCreator.MASTERCARD);
    }
}