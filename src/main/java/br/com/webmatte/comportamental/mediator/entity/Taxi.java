package br.com.webmatte.comportamental.mediator.entity;

import br.com.webmatte.comportamental.mediator.control.CentralTaxi;
import lombok.Getter;
import lombok.Setter;

import static java.lang.Math.random;

/**
 * @author Anderson Matte
 */
@Getter
@Setter
public class Taxi {

    private static int contador = 0;
    private CentralTaxi centralTaxi;
    private Integer id;

    public Taxi(CentralTaxi centralTaxi, Integer id) {
        this.centralTaxi = centralTaxi;
        this.id = id;
    }

    public void atendePassageiro() {
        try {
            Thread.sleep((long) (random() * 3000.0));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.centralTaxi.adicionaTaxiDisponivel(this);
    }

}
