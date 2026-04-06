package br.com.webmatte.criacao.abstractfactory.factory;

import br.com.webmatte.criacao.abstractfactory.emissor.EspectrometroMassa;
import br.com.webmatte.criacao.abstractfactory.interfaces.EquipamentoAnalise;
import br.com.webmatte.criacao.abstractfactory.interfaces.EquipamentoCultura;
import br.com.webmatte.criacao.abstractfactory.interfaces.LaboratorioFactory;
import br.com.webmatte.criacao.abstractfactory.receptor.Biorreator;

/**
 * @author Anderson Matte
 */
public class LaboratorioProteomicaFactory implements LaboratorioFactory {

    @Override
    public EquipamentoAnalise createEquipamentoAnalise() {
        return new EspectrometroMassa();
    }

    @Override
    public EquipamentoCultura createEquipamentoCultura() {
        return new Biorreator();
    }
}
