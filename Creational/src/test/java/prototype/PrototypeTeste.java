package prototype;

import org.junit.Test;
import prototype.entity.Ferias;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Anderson Matte
 */
public class PrototypeTeste {

    @Test
    public void testaPrototype() {
        String nome = "1º Férias";
        LocalDate vencimento = LocalDate.now();
        Set<String> chaves = new HashSet<String>();
        chaves.add("1º Férias");
        chaves.add("2º Férias");
        chaves.add("3º Férias");

        Ferias ferias = new Ferias(nome, vencimento, chaves);
        System.out.println(ferias);

        Ferias clone = ferias.clone();
        System.out.println(clone);
    }

}
