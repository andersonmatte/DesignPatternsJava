package mediator.entity;

import lombok.Getter;
import lombok.Setter;
import mediator.control.CentralTaxi;

/**
 * @author Anderson Matte
 */
@Getter
@Setter
public class Passageiro implements Runnable {

    private String nome;
    private CentralTaxi centralTaxi;

    public Passageiro(String nome, CentralTaxi centralTaxi) {
        this.nome = nome;
        this.centralTaxi = centralTaxi;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            this.centralTaxi.chamaTaxi(this);
        }
    }

}
