package br.com.webmatte.comportamental.state.control;

import br.com.webmatte.comportamental.state.interfaces.EstadoCelular;
import br.com.webmatte.comportamental.state.state.CelulaNormal;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Anderson Matte
 */
@Getter
public class Celula {

    @Setter
    private EstadoCelular estado;
    private String id;

    public Celula(String id) {
        this.id = id;
        this.estado = new CelulaNormal(this);
    }

    public Celula(EstadoCelular estado) {
        this.estado = estado;
    }

    public String analisarComportamentoCelular(Double nivelMetabolico, Double taxaDivisao) {
        return this.estado.analisarAtividadeCelular(nivelMetabolico, taxaDivisao);
    }

    public String getStatus() {
        return estado.getStatus();
    }

    public boolean isCancerigena() {
        return estado.isCancerigena();
    }

    public void detectarMutacao() {
        estado.detectarMutacao();
    }

    public String dividir() {
        return estado.dividir();
    }

    public void aplicarTratamento() {
        estado.aplicarTratamento();
    }

    public String divisao() {
        return estado.divisao();
    }

}
