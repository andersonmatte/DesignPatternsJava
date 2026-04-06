package br.com.webmatte.criacao.abstractfactory.factory;

import br.com.webmatte.criacao.abstractfactory.creator.EmissorCreator;
import br.com.webmatte.criacao.abstractfactory.creator.ReceptorCreator;
import br.com.webmatte.criacao.abstractfactory.interfaces.ComunicadorFactory;
import br.com.webmatte.criacao.abstractfactory.interfaces.Emissor;
import br.com.webmatte.criacao.abstractfactory.interfaces.Receptor;

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