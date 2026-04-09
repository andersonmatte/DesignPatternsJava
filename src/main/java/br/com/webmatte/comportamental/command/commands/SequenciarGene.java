package br.com.webmatte.comportamental.command.commands;

import br.com.webmatte.comportamental.command.control.SequenciadorDNA;
import br.com.webmatte.comportamental.command.interfaces.Comando;

/**
 * @author Anderson Matte
 */
public class SequenciarGene implements Comando {

    private final SequenciadorDNA sequenciadorDNA;
    String gene;

    public SequenciarGene(SequenciadorDNA sequenciadorDNA, String gene) {
        this.sequenciadorDNA = sequenciadorDNA;
        this.gene = gene;
    }

    @Override
    public void executa() throws InterruptedException {
        this.sequenciadorDNA.sequenciarGene(this.gene);
    }

}
