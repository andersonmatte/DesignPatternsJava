package br.com.webmatte.criacao.abstractfactory.interfaces;

/**
 * @author Anderson Matte
 */
public interface LaboratorioFactory {

    EquipamentoAnalise createEquipamentoAnalise();

    EquipamentoCultura createEquipamentoCultura();

}
