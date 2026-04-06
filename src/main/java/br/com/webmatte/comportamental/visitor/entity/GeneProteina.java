package br.com.webmatte.comportamental.visitor.entity;

import br.com.webmatte.comportamental.visitor.interfaces.AnalisadorGenetico;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Anderson Matte
 */
@Getter
@Setter
public class GeneProteina extends Gene {

    private String proteinaCodificada;

    public GeneProteina(String nome, String sequencia, String cromossomo, String proteinaCodificada) {
        super(nome, sequencia, cromossomo);
        this.proteinaCodificada = proteinaCodificada;
    }

    public void aceita(AnalisadorGenetico analisadorGenetico) {
        analisadorGenetico.analisa(this);
    }

}
