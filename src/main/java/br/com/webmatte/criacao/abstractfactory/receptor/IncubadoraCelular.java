package br.com.webmatte.criacao.abstractfactory.receptor;

import br.com.webmatte.criacao.abstractfactory.interfaces.EquipamentoCultura;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Anderson Matte
 */
@Slf4j
public class IncubadoraCelular implements EquipamentoCultura {

    @Override
    public String cultivarCelulas(String tipoCelula) {
        log.info("Iniciando cultura de células: {}", tipoCelula);
        log.info("Controlando temperatura: 37°C, CO2: 5%, umidade: 95%");
        return "Cultura de " + tipoCelula + " estabelecida com sucesso";
    }

}
