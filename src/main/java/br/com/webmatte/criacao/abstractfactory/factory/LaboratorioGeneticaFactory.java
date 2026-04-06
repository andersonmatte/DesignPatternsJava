package br.com.webmatte.criacao.abstractfactory.factory;

import br.com.webmatte.criacao.abstractfactory.emissor.SequenciadorDNA;
import br.com.webmatte.criacao.abstractfactory.interfaces.EquipamentoAnalise;
import br.com.webmatte.criacao.abstractfactory.interfaces.EquipamentoCultura;
import br.com.webmatte.criacao.abstractfactory.interfaces.LaboratorioFactory;
import br.com.webmatte.criacao.abstractfactory.receptor.IncubadoraCelular;

/**
 * @author Anderson Matte
 */
public class LaboratorioGeneticaFactory implements LaboratorioFactory {

    @Override
    public EquipamentoAnalise createEquipamentoAnalise() {
        return new SequenciadorDNA();
    }

    @Override
    public EquipamentoCultura createEquipamentoCultura() {
        return new IncubadoraCelular();
    }
}
