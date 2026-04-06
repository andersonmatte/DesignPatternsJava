package br.com.webmatte.comportamental.visitor.entity;

import br.com.webmatte.comportamental.visitor.interfaces.ElementoGenetico;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Anderson Matte
 */
@Getter
@Setter
public abstract class Gene implements ElementoGenetico {

    private String nome;
    private String sequencia;
    private String cromossomo;

    protected Gene(String nome, String sequencia, String cromossomo) {
        this.nome = nome;
        this.sequencia = sequencia;
        this.cromossomo = cromossomo;
    }

}
