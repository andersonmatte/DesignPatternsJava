package br.com.webmatte.comportamental.command.commands;

import br.com.webmatte.comportamental.command.control.SequenciadorDNA;
import br.com.webmatte.comportamental.command.interfaces.Comando;

/**
 * @author Anderson Matte
 */
public class AumentarExpressaoGenica implements Comando {

    private SequenciadorDNA sequenciadorDNA;
    private int nivel;

    public AumentarExpressaoGenica(SequenciadorDNA sequenciadorDNA, int nivel) {
        this.sequenciadorDNA = sequenciadorDNA;
        this.nivel = nivel;
    }

    @Override
    public void executa() {
        this.sequenciadorDNA.aumentarExpressaoGenica(this.nivel);
    }

}
