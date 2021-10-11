package mediator.entity;

import lombok.Getter;
import lombok.Setter;
import mediator.control.CentralTaxi;

/**
 * @author Anderson Matte
 */
@Getter
@Setter
public class Taxi {

    private CentralTaxi centralTaxi;
    private Integer id;
    private static int contador = 0;

    public Taxi(CentralTaxi centralTaxi, Integer id) {
        this.centralTaxi = centralTaxi;
        this.id = id;
    }

    public void atendePassageiro() {
        try {
            Thread.sleep((long) (Math.random() * 3000.0));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.centralTaxi.adicionaTaxiDisponivel(this);
    }

}
