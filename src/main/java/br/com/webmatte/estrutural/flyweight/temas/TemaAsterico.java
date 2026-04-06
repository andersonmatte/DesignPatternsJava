package br.com.webmatte.estrutural.flyweight.temas;

import br.com.webmatte.estrutural.flyweight.interfaces.TemaFlyweight;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * @author Anderson Matte
 */
@Slf4j
public class TemaAsterico implements TemaFlyweight {

    @Override
    public void imprime(String titulo, String conteudo) {
        log.info("********** {} **********", titulo);
        log.info(conteudo);
        char[] rodape = new char[22 + titulo.length()];
        Arrays.fill(rodape, '*');
        log.info(Arrays.toString(rodape));
    }

}