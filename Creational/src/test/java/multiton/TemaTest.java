package multiton;

import org.junit.Test;

/**
 * @author Anderson Matte
 */
public class TemaTest {

    Tema temaLight = Tema.getInstance(Tema.LIGHT);
    Tema temaDark = Tema.getInstance(Tema.DARK);

    @Test
    public void testaTemaLight(){
        System.out.println("Tema: " +temaLight.getNome());
        System.out.println("Cor da Fonte: " +temaLight.getCorDaFonte());
        System.out.println("Cor de Fundo: " +temaLight.getCorDeFundo());
    }

    @Test
    public void testaTemaDark(){
        System.out.println("Tema: " +temaDark.getNome());
        System.out.println("Cor da Fonte: " +temaDark.getCorDaFonte());
        System.out.println("Cor de Fundo: " +temaDark.getCorDeFundo());
    }

    @Test
    public void testaComparacao(){
        System.out.println("---------------------------------");
        System.out.println("Comparando objetos...");
        System.out.println(temaLight == temaDark);
    }


}
