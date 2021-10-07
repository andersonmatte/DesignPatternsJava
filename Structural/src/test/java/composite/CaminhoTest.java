package composite;

import composite.control.Caminho;
import composite.control.TrechoAndado;
import composite.control.TrechoCarro;
import composite.interfaces.Trecho;
import org.junit.Test;

/**
 * @author Anderson Matte
 */
public class CaminhoTest {

    @Test
    public void testaTrecho() {
        Trecho trecho1 = new TrechoAndado("Vá até a Rua Beija Flor, número 104", 500D);
        Trecho trecho2 = new TrechoCarro("Vá até a Rua Sabiá, número 78", 1500D);
        Trecho trecho3 = new TrechoCarro("Vire a direita na Avenida Ipiranga ", 750D);

        Caminho caminho1 = new Caminho();
        caminho1.adiciona(trecho1);
        caminho1.adiciona(trecho2);

        System.out.println("Caminho 1 : ");
        caminho1.imprimir();

        Caminho caminho2 = new Caminho();
        caminho2.adiciona(caminho1);
        caminho2.adiciona(trecho3);

        System.out.println("Caminho 2 : ");
        caminho2.imprimir();
    }

}
