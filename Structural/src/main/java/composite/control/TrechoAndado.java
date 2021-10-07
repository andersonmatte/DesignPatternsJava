package composite.control;

import composite.interfaces.Trecho;

/**
 * @author Anderson Matte
 */
public class TrechoAndado implements Trecho {

    private String direcao;
    private Double distancia;

    public TrechoAndado(String direcao, Double distancia) {
        this.direcao = direcao;
        this.distancia = distancia;
    }

    @Override
    public void imprimir() {
        System.out.println("Percorrendo o caminho andando: ");
        System.out.println(this.direcao);
        System.out.println("A distância percorrida será:" + this.distancia + " metros");
    }

}
