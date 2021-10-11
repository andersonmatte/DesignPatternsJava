package observer;

import observer.control.Acao;
import observer.control.Corretora;
import org.junit.Test;

/**
 * @author Anderson Matte
 */
public class ObserverTest {

    @Test
    public void testaObserver() {
        Acao acao = new Acao("Codigo 1", 24.90);
        Corretora corretora1 = new Corretora("Foxter");
        acao.registraInteressado(corretora1);
        Corretora corretora2 = new Corretora("Rospide");
        acao.registraInteressado(corretora2);
        acao.setValor(59D);
    }

}
