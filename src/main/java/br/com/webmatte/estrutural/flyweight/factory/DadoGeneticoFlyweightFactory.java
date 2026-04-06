package br.com.webmatte.estrutural.flyweight.factory;

import br.com.webmatte.estrutural.flyweight.interfaces.DadoGeneticoFlyweight;
import br.com.webmatte.estrutural.flyweight.temas.DadoProteina;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Anderson Matte
 */
@Slf4j
public class DadoGeneticoFlyweightFactory {

    public static final Class<DadoProteina> DADO_PROTEINA = DadoProteina.class;

    private static Map<Class<? extends DadoGeneticoFlyweight>, DadoGeneticoFlyweight> dados = new HashMap<>();

    private DadoGeneticoFlyweightFactory() {
        /* This utility class should not be instantiated */
    }

    public static DadoGeneticoFlyweight getDado(Class<? extends DadoGeneticoFlyweight> clazz) {
        if (!dados.containsKey(clazz)) {
            try {
                dados.put(clazz, clazz.getDeclaredConstructor().newInstance());
            } catch (Exception e) {
                log.error("Erro ao criar dado genético", e);
            }
        }
        return dados.get(clazz);
    }

}
