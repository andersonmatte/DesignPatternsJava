package br.com.webmatte.estrutural.composite.control;

import br.com.webmatte.estrutural.composite.interfaces.Trecho;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Anderson Matte
 */
@Slf4j
public class TrechoCarro implements Trecho {

    private String direcao;
    private Double distancia;

    public TrechoCarro(String direcao, Double distancia) {
        this.direcao = direcao;
        this.distancia = distancia;
    }

    @Override
    public void imprimir() {
        log.info("Percorrendo o caminho de carro: ");
        log.info(this.direcao);
        log.info("A distância percorrida será:" + this.distancia + " metros");
    }

}