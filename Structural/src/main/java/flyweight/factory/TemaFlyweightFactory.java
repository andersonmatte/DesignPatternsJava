package flyweight.factory;

import flyweight.interfaces.TemaFlyweight;
import flyweight.temas.TemaAndersonMatte;
import flyweight.temas.TemaAsterico;
import flyweight.temas.TemaHifen;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Anderson Matte
 */
public class TemaFlyweightFactory {

    private static Map<Class<? extends TemaFlyweight>, TemaFlyweight> temas = new HashMap<Class<? extends TemaFlyweight>, TemaFlyweight>();
    public static final Class<TemaAsterico> ASTERICO = TemaAsterico.class;
    public static final Class<TemaHifen> HIFEN = TemaHifen.class;
    public static final Class<TemaAndersonMatte> ANDERSON_MATTE = TemaAndersonMatte.class;

    public static TemaFlyweight getTema(Class<? extends TemaFlyweight> clazz) {
        if (!temas.containsKey(clazz)) {
            try {
                temas.put(clazz, clazz.newInstance());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return temas.get(clazz);
    }

}
