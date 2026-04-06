package br.com.webmatte.comportamental.visitor.interfaces;

import br.com.webmatte.comportamental.visitor.entity.GeneProteina;
import br.com.webmatte.comportamental.visitor.entity.GeneRegulador;

/**
 * @author Anderson Matte
 */
public interface AnalisadorGenetico {

    void analisa(GeneProteina geneProteina);

    void analisa(GeneRegulador geneRegulador);

}
