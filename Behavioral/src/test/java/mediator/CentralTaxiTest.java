package mediator;

import mediator.control.CentralTaxi;
import mediator.entity.Passageiro;
import mediator.entity.Taxi;
import org.junit.Test;

/**
 * @author Anderson Matte
 */
public class CentralTaxiTest {

    CentralTaxi centralTaxi = new CentralTaxi();
    Passageiro passageiro1 = new Passageiro("Anderson Matte", centralTaxi);
    Passageiro passageiro2 = new Passageiro("Alicia Mendes", centralTaxi);
    Passageiro passageiro3 = new Passageiro("Juliana Chaves", centralTaxi);
    Taxi taxi1 = new Taxi(this.centralTaxi, 1);
    Taxi taxi2 = new Taxi(this.centralTaxi, 2);

    @Test
    public void adicionaTaxiDisponivel() {
        this.centralTaxi.adicionaTaxiDisponivel(this.taxi1);
        this.centralTaxi.adicionaTaxiDisponivel(this.taxi2);
        new Thread(this.passageiro1).start();
        new Thread(this.passageiro2).start();
        new Thread(this.passageiro3).start();
    }

}
