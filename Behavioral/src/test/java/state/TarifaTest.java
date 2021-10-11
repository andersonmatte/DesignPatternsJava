package state;

import org.junit.Test;
import state.control.Preco1;
import state.control.Preco2;
import state.control.Tarifa;
import state.interfaces.Preco;

/**
 * @author Anderson Matte
 */
public class TarifaTest {

    @Test
    public void testaTarifa() {
        Preco preco1 = new Preco1();
        Preco preco2 = new Preco2();
        Tarifa tarifa = new Tarifa(preco1);

        Double valor1 = tarifa.calculaValorFinalCorrida(10d, 20d);
        System.out.println("Valor da corrida em dinâmica 1: " + valor1);

        //tarifa.setPreco(preco2);
        Double valor2 = tarifa.calculaValorFinalCorrida(5d, 30d);
        System.out.println("Valor da corrida em dinâmica 2: " + valor2);
    }

}
