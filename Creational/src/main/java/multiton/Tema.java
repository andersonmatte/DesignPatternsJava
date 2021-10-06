package multiton;

import lombok.Getter;
import lombok.Setter;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Anderson Matte
 */
@Getter
@Setter
public class Tema {

    private String nome;
    private Color corDeFundo;
    private Color corDaFonte;

    public static final String LIGHT = "Light";
    public static final String DARK = "Dark";

    private static Map<String, Tema> temas = new HashMap<String, Tema>();

    private Tema() {

    }

    static {
        Tema temaLight = new Tema();
        temaLight.setNome(Tema.LIGHT);
        temaLight.setCorDeFundo(Color.LIGHT_GRAY);
        temaLight.setCorDaFonte(Color.BLACK);
        temas.put(temaLight.getNome(), temaLight);

        Tema temaDark = new Tema();
        temaDark.setNome(Tema.DARK);
        temaDark.setCorDeFundo(Color.BLACK);
        temaDark.setCorDaFonte(Color.LIGHT_GRAY);
        temas.put(temaDark.getNome(), temaDark);
    }

    public static Tema getInstance(String nome) {
        return Tema.temas.get(nome);
    }

}
