package br.com.webmatte.comportamental.command.commands;

import br.com.webmatte.comportamental.command.control.SequenciadorDNA;
import br.com.webmatte.comportamental.command.interfaces.Comando;

/**
 * @author Anderson Matte
 */
public class DiminuirExpressaoGenica implements Comando {

    private final SequenciadorDNA sequenciadorDNA;
    private final int nivel;

    public DiminuirExpressaoGenica(SequenciadorDNA sequenciadorDNA, int nivel) {
        this.sequenciadorDNA = sequenciadorDNA;
        this.nivel = nivel;
    }

    @Override
    public void executa() {
        this.sequenciadorDNA.diminuirExpressaoGenica(this.nivel);
    }

}
