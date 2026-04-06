package br.com.webmatte.comportamental.state.control;

import br.com.webmatte.comportamental.state.interfaces.EstadoCelular;

/**
 * @author Anderson Matte
 */
public class EstadoCancerigeno implements EstadoCelular {

    @Override
    public String analisarAtividadeCelular(Double nivelMetabolico, Double taxaDivisao) {
        return "Célula em estado cancerígeno: Metabolismo elevado " + nivelMetabolico +
                ", Taxa de divisão anormal " + taxaDivisao + " - Requer intervenção médica";
    }

}
