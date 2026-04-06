package br.com.webmatte.criacao.factorymethody.emissor;

import br.com.webmatte.criacao.factorymethody.interfaces.CulturaCelular;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Anderson Matte
 */
@Slf4j
public class CulturaCelularAnimal implements CulturaCelular {

    @Override
    public String cultivar(String meioCultura) {
        log.info("Iniciando cultura de células animais em meio: {}", meioCultura);
        log.info("Cultivando em incubadora com 5% CO₂ a 37°C...");
        return "Cultura de células animais estabelecida em " + meioCultura + " com sucesso";
    }

}
