package br.com.webmatte.criacao.abstractfactory.receptor;

import br.com.webmatte.criacao.abstractfactory.interfaces.EquipamentoCultura;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Anderson Matte
 */
@Slf4j
public class Biorreator implements EquipamentoCultura {

    @Override
    public String cultivarCelulas(String tipoCelula) {
        log.info("Iniciando cultura em biorreator: {}", tipoCelula);
        log.info("Agitando: 120 rpm, Aeração: 1.0 vvm, pH: 7.2");
        return "Produção em biorreator de " + tipoCelula + " otimizada";
    }

}
