package br.com.webmatte.comportamental.visitor.entity;

import br.com.webmatte.comportamental.visitor.visitor.AnalisadorMolecular;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Anderson Matte
 */
@Getter
@Setter
public class GeneProteina extends Gene {

    private String proteinaCodificada;

    public GeneProteina(String nome, String proteinaCodificada, String sequencia) {
        super(nome, sequencia, "CHR1");
        this.proteinaCodificada = proteinaCodificada;
    }

    @Override
    public void aceitar(AnalisadorMolecular analisador) {
        analisador.visitaGeneProteina(this);
    }

}
