package br.com.webmatte.criacao.abstractFactory.factory;

import br.com.webmatte.criacao.abstractFactory.creator.EmissorCreator;
import br.com.webmatte.criacao.abstractFactory.creator.ReceptorCreator;
import br.com.webmatte.criacao.abstractFactory.interfaces.ComunicadorFactory;
import br.com.webmatte.criacao.abstractFactory.interfaces.Emissor;
import br.com.webmatte.criacao.abstractFactory.interfaces.Receptor;

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