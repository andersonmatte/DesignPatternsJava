package flyweight.temas;

import flyweight.interfaces.TemaFlyweight;

import java.util.Arrays;

/**
 * @author Anderson Matte
 */
public class TemaAndersonMatte implements TemaFlyweight {

    @Override
    public void imprime(String titulo, String conteudo) {
        System.out.println("$$$$$$$$$$ " + titulo.toUpperCase() + " $$$$$$$$$$");
        System.out.println(conteudo);
        char[] rodapeEsquerda = new char[(int) Math.floor((6 + titulo.length()) / 2.0)];
        char[] rodapeDireita = new char[(int) Math.ceil((6 + titulo.length()) / 2.0)];
        Arrays.fill(rodapeEsquerda, '$');
        Arrays.fill(rodapeDireita, '$');
        System.out.println(new String(rodapeEsquerda) + "www.andersonmatte.com.br " + new String(rodapeDireita));
    }

}
