package br.com.webmatte.comportamental.mediator.entity;

import br.com.webmatte.comportamental.mediator.control.CentralTaxi;
import lombok.Getter;
import lombok.Setter;

import java.util.Random;

/**
 * @author Anderson Matte
 */
@Getter
@Setter
public class Taxi {

    private static final Random random = new Random();
    private static int contador = 0;
    private CentralTaxi centralTaxi;
    private Integer id;

    public Taxi(CentralTaxi centralTaxi, Integer id) {
        this.centralTaxi = centralTaxi;
        this.id = id;
    }

    public void atendePassageiro() {
        try {
            Thread.sleep(random.nextInt(3000));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
        this.centralTaxi.adicionaTaxiDisponivel(this);
    }

}
