package br.com.webmatte.comportamental.visitor.interfaces;

import br.com.webmatte.comportamental.visitor.visitor.AnalisadorMolecular;

/**
 * @author Anderson Matte
 */
public interface ElementoGenetico {

    void aceitar(AnalisadorMolecular analisador);

}
