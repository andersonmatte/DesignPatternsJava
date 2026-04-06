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
public class Acao {

    private String codigo;
    private Double valor;

    private Set<AcaoObserver> interessados = new HashSet<>();

    public Acao(String codigo, Double valor) {
        this.codigo = codigo;
        this.valor = valor;
    }

    public void registraInteressado(AcaoObserver interessado) {
        this.interessados.add(interessado);
    }

    public void cancelaInteressado(AcaoObserver interessado) {
        this.interessados.remove(interessado);
    }

    public void setValor() {
        for (AcaoObserver interessado : this.interessados) {
            interessado.notificaAlteracao(this);
        }
    }

}
