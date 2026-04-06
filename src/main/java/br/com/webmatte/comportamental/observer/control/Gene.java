package br.com.webmatte.comportamental.observer.control;

import br.com.webmatte.comportamental.observer.interfaces.AcaoObserver;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Anderson Matte
 */
@Getter
@Setter
public class Gene {

    private String codigo;
    private String sequencia;
    private String tipoMutacao;

    private Set<AcaoObserver> observadores = new HashSet<>();

    public Gene(String codigo, String sequencia, String tipoMutacao) {
        this.codigo = codigo;
        this.sequencia = sequencia;
        this.tipoMutacao = tipoMutacao;
    }

    public void registraObservador(AcaoObserver observador) {
        this.observadores.add(observador);
    }

    public void cancelaObservador(AcaoObserver observador) {
        this.observadores.remove(observador);
    }

    public void setTipoMutacao(String novoTipoMutacao) {
        this.tipoMutacao = novoTipoMutacao;
        for (AcaoObserver observador : this.observadores) {
            observador.notificaAlteracao(this);
        }
    }

}
