package br.com.webmatte.estrutural.flyweight.temas;

import br.com.webmatte.estrutural.flyweight.interfaces.TemaFlyweight;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * @author Anderson Matte
 */
@Slf4j
public class TemaAndersonMatte implements TemaFlyweight {

    @Override
    public void imprime(String titulo, String conteudo) {
        log.info("$$$$$$$$$$ {} $$$$$$$$$$", titulo.toUpperCase());
        log.info(conteudo);
        char[] rodapeEsquerda = new char[(int) Math.floor((6 + titulo.length()) / 2.0)];
        char[] rodapeDireita = new char[(int) Math.ceil((6 + titulo.length()) / 2.0)];
        Arrays.fill(rodapeEsquerda, '$');
        Arrays.fill(rodapeDireita, '$');
        log.info(new String(rodapeEsquerda) + "www.andersonmatte.com.br " + new String(rodapeDireita));
    }

}
