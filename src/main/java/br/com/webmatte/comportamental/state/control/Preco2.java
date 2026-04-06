package br.com.webmatte.comportamental.state.control;

import br.com.webmatte.comportamental.state.interfaces.Preco;

/**
 * @author Anderson Matte
 */
public class Preco2 implements Preco {

    @Override
    public Double calculaValorCorrida(Double tempo, Double distancia) {
        return 10.0 + tempo * 3.0 + distancia * 3.7;
    }

}
