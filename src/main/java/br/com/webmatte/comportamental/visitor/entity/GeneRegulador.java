package br.com.webmatte.comportamental.visitor.entity;

import br.com.webmatte.comportamental.visitor.interfaces.AnalisadorGenetico;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Anderson Matte
 */
@Getter
@Setter
public class GeneRegulador extends Gene {

    private String geneAlvo;

    public GeneRegulador(String nome, String sequencia, String cromossomo, String geneAlvo) {
        super(nome, sequencia, cromossomo);
        this.geneAlvo = geneAlvo;
    }

    public void aceita(AnalisadorGenetico analisadorGenetico) {
        analisadorGenetico.analisa(this);
    }

}
