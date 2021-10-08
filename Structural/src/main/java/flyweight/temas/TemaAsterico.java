package flyweight.temas;

import flyweight.interfaces.TemaFlyweight;

import java.util.Arrays;

/**
 * @author Anderson Matte
 */
public class TemaAsterico implements TemaFlyweight {

    @Override
    public void imprime(String titulo, String conteudo) {
        System.out.println("********** " + titulo + " **********");
        System.out.println(conteudo);
        char[] rodape = new char[22 + titulo.length()];
        Arrays.fill(rodape, '*');
        System.out.println(rodape);
    }

}