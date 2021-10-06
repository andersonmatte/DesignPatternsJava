package singlenton.configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Anderson Matte
 */
public class Configuracao {

    private Map<String, String> properties;
    private static Configuracao instance;

    private Configuracao(){
        this.properties = new HashMap<String, String>();
        this.properties.put("time-zone", "America/Sao_Paulo");
        this.properties.put("currency-code", "BRL");
    }

    public static Configuracao getInstance(){
        if (Configuracao.instance == null){
            Configuracao.instance = new Configuracao();
        }
        return Configuracao.instance;
    }

    public String getProperties(String nomePropriedade){
        return this.properties.get(nomePropriedade);
    }

}
