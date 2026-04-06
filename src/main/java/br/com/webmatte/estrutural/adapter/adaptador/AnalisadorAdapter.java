package br.com.webmatte.estrutural.adapter.adaptador;

import br.com.webmatte.estrutural.adapter.control.AnalisadorSequencias;
import br.com.webmatte.estrutural.adapter.control.AnalisadorUnificado;
import br.com.webmatte.estrutural.adapter.entity.AmostraBio;

/**
 * @author Anderson Matte
 */
public class AnalisadorAdapter extends AnalisadorSequencias {

    private final AnalisadorUnificado analisadorUnificado;

    public AnalisadorAdapter() {
        this.analisadorUnificado = new AnalisadorUnificado();
    }

    public AnalisadorAdapter(AnalisadorUnificado analisadorUnificado) {
        this.analisadorUnificado = analisadorUnificado;
    }

    @Override
    public void analisarFASTA(AmostraBio amostra) {
        this.analisadorUnificado.analisar(amostra, "FASTA");
    }

    @Override
    public void analisarGenBank(AmostraBio amostra) {
        this.analisadorUnificado.analisar(amostra, "GENBANK");
    }

}
