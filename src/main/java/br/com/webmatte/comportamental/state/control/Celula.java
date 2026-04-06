package br.com.webmatte.comportamental.state.control;

import br.com.webmatte.comportamental.state.interfaces.EstadoCelular;

/**
 * @author Anderson Matte
 */
public class Celula {

    private EstadoCelular estado;

    public Celula(EstadoCelular estado) {
        this.estado = estado;
    }

    public void setEstado(EstadoCelular estado) {
        this.estado = estado;
    }

    public String analisarComportamentoCelular(Double nivelMetabolico, Double taxaDivisao) {
        return this.estado.analisarAtividadeCelular(nivelMetabolico, taxaDivisao);
    }

}
