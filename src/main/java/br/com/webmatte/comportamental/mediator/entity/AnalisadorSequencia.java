package br.com.webmatte.comportamental.mediator.entity;

import br.com.webmatte.comportamental.mediator.control.CoordenadorAnaliseGenomica;
import lombok.Getter;
import lombok.Setter;

import java.util.Random;

/**
 * @author Anderson Matte
 */
@Getter
@Setter
public class AnalisadorSequencia {

    private static final Random random = new Random();
    private static int contador = 0;
    private CoordenadorAnaliseGenomica coordenador;
    private Integer id;

    public AnalisadorSequencia(CoordenadorAnaliseGenomica coordenador, Integer id) {
        this.coordenador = coordenador;
        this.id = id;
    }

    public void analisaAmostra() {
        try {
            Thread.sleep(random.nextInt(3000));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
        this.coordenador.adicionaAnalisadorDisponivel(this);
    }

}
