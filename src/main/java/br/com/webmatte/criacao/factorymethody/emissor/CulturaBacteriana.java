package br.com.webmatte.criacao.factorymethody.emissor;

import br.com.webmatte.criacao.factorymethody.interfaces.CulturaCelular;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Anderson Matte
 */
@Slf4j
public class CulturaBacteriana implements CulturaCelular {

    @Override
    public String cultivar(String meioCultura) {
        log.info("Iniciando cultura bacteriana em meio: {}", meioCultura);
        log.info("Incubando a 37°C por 24 horas...");
        return "Cultura bacteriana estabelecida em " + meioCultura + " com sucesso";
    }

}
