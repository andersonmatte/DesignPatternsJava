package br.com.webmatte.comportamental.visitor.entity;

import br.com.webmatte.comportamental.visitor.visitor.AnalisadorMolecular;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Anderson Matte
 */
@Getter
@Setter
public class GeneRegulador extends Gene {

    private String geneAlvo;

    public GeneRegulador(String nome, String proteinaCodificada, String sequencia) {
        super(nome, sequencia, "CHR1");
        this.geneAlvo = proteinaCodificada;
    }

    @Override
    public void aceitar(AnalisadorMolecular analisador) {
        analisador.visitaGeneRegulador(this);
    }

}
