package iterator;

import iterator.control.Nomes;
import org.junit.Test;

import java.util.Iterator;

/**
 * @author Anderson Matte
 */
public class IteratorTest {

    @Test
    public void testaIterator() {
        Nomes nomes = new Nomes(this.getNomes());
        Iterator<String> iterator = nomes.iterator();
        iterator.hasNext();
        iterator.remove();

        while (iterator.hasNext()) {
            String nome = iterator.next();
            System.out.println(nome);
        }

        System.out.println("----------------------");
        System.out.println("Testando o laço.......");
        for (Object nome : getNomes()) {
            System.out.println(nome);
        }

    }

    public String[] getNomes() {
        String[] nomes = new String[5];
        nomes[0] = "Anderson Matte";
        nomes[1] = "Alicia Mendes";
        nomes[2] = "Juliana Chaves";
        nomes[3] = "Marcos Silva";
        nomes[4] = "Josiane Pedralli";
        return nomes;
    }

}
