package br.com.webmatte.comportamental.mediator.entity;

import br.com.webmatte.comportamental.mediator.control.CoordenadorAnaliseGenomica;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Anderson Matte
 */
@Getter
@Setter
public class AmstraGenetica implements Runnable {

    private String codigo;
    private String tipoSequencia;
    private CoordenadorAnaliseGenomica coordenador;

    public AmstraGenetica(String codigo, String tipoSequencia, CoordenadorAnaliseGenomica coordenador) {
        this.codigo = codigo;
        this.tipoSequencia = tipoSequencia;
        this.coordenador = coordenador;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            this.coordenador.processaAmostra(this);
        }
    }

}
