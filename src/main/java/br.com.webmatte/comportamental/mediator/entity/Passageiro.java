package br.com.webmatte.comportamental.mediator.entity;

import lombok.Getter;
import lombok.Setter;
import br.com.webmatte.comportamental.mediator.control.CentralTaxi;

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
