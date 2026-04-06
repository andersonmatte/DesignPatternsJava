package br.com.webmatte.comportamental.observer.control;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Anderson Matte
 */
@Getter
@Setter
public class Mutacao {

    private String tipo;
    private String posicao;

    public Mutacao(String tipo, String posicao) {
        this.tipo = tipo;
        this.posicao = posicao;
    }

}
