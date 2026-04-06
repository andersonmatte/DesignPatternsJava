package br.com.webmatte.criacao.singlenton;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Anderson Matte
 */
public class Configuracao {

    private static Configuracao instance;
    private Map<String, String> properties;

    private Configuracao() {
        this.properties = new HashMap<>();
        this.properties.put("time-zone", "America/Sao_Paulo");
        this.properties.put("currency-code", "BRL");
    }

    public static Configuracao getInstance() {
        if (Configuracao.instance == null) {
            Configuracao.instance = new Configuracao();
        }
        return Configuracao.instance;
    }

    public String getProperties(String nomePropriedade) {
        return this.properties.get(nomePropriedade);
    }

}
