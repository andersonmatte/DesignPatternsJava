package state.control;

import state.interfaces.Preco;

/**
 * @author Anderson Matte
 */
public class Tarifa {

    private Preco preco;

    public Tarifa(Preco preco) {
        this.preco = preco;
    }

    public void setPreco(Preco preco) {
        this.setPreco(preco);
    }

    public Double calculaValorFinalCorrida(Double tempo, Double distancia) {
        return this.preco.calculaValorCorrida(tempo, distancia);
    }

}
