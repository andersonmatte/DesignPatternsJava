package adapter;

import adapter.adaptador.ControlePontoAdapter;
import adapter.control.ControlePonto;
import adapter.entity.Funcionario;
import org.junit.Test;

/**
 * @author Anderson Matte
 */
public class ControlePontoTest {

    ControlePonto controlePonto = new ControlePontoAdapter();

    @Test
    public void testaEntrada() throws InterruptedException {
        Funcionario funcionario = new Funcionario("Anderson Matte");
        this.controlePonto.registrarEntrada(funcionario);
        Thread.sleep(5000);
        this.testaSaida();
    }

    public void testaSaida() {
        Funcionario funcionario = new Funcionario("Anderson Matte");
        this.controlePonto.registrarSaida(funcionario);
    }

}
