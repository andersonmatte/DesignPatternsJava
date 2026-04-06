package br.com.webmatte.estrutural.flyweight.factory;

import br.com.webmatte.estrutural.flyweight.interfaces.TemaFlyweight;
import br.com.webmatte.estrutural.flyweight.temas.TemaAndersonMatte;
import br.com.webmatte.estrutural.flyweight.temas.TemaAsterico;
import br.com.webmatte.estrutural.flyweight.temas.TemaHifen;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Anderson Matte
 */
public class TemaFlyweightFactory {

    public static final Class<TemaAsterico> ASTERICO = TemaAsterico.class;
    public static final Class<TemaHifen> HIFEN = TemaHifen.class;
    public static final Class<TemaAndersonMatte> ANDERSON_MATTE = TemaAndersonMatte.class;
    private static Map<Class<? extends TemaFlyweight>, TemaFlyweight> temas = new HashMap<>();

    private TemaFlyweightFactory() {
        /* This utility class should not be instantiated */
    }

    public static TemaFlyweight getTema(Class<? extends TemaFlyweight> clazz) {
        if (!temas.containsKey(clazz)) {
            try {
                temas.put(clazz, clazz.getDeclaredConstructor().newInstance());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return temas.get(clazz);
    }

}
