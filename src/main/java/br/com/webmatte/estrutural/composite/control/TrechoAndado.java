package br.com.webmatte.estrutural.composite.control;

import br.com.webmatte.estrutural.composite.interfaces.Trecho;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Anderson Matte
 */
@Slf4j
public class TrechoAndado implements Trecho {

    private String direcao;
    private Double distancia;

    public TrechoAndado(String direcao, Double distancia) {
        this.direcao = direcao;
        this.distancia = distancia;
    }

    @Override
    public void imprimir() {
        log.info("Percorrendo o caminho andando: ");
        log.info(this.direcao);
        log.info("A distância percorrida será:" + this.distancia + " metros");
    }

}
