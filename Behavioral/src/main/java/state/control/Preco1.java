package state.control;

import state.interfaces.Preco;

/**
 * @author Anderson Matte
 */
public class Preco1 implements Preco {

    @Override
    public Double calculaValorCorrida(Double tempo, Double distancia) {
        return 5.0 + tempo * 1.5 + distancia * 1.7;
    }

}
