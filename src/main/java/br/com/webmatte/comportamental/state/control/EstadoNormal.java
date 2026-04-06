package br.com.webmatte.comportamental.state.control;

import br.com.webmatte.comportamental.state.interfaces.EstadoCelular;

/**
 * @author Anderson Matte
 */
public class EstadoNormal implements EstadoCelular {

    @Override
    public String analisarAtividadeCelular(Double nivelMetabolico, Double taxaDivisao) {
        return "Célula em estado normal: Metabolismo " + nivelMetabolico +
                ", Taxa de divisão " + taxaDivisao + " - Funcionamento adequado";
    }

}
