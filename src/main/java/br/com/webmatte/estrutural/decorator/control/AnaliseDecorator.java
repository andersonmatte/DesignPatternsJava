package br.com.webmatte.estrutural.decorator.control;

import br.com.webmatte.estrutural.decorator.interfaces.AnaliseBio;

/**
 * @author Anderson Matte
 */
public abstract class AnaliseDecorator implements AnaliseBio {

    protected AnaliseBio analise;

    public AnaliseDecorator(AnaliseBio analise) {
        this.analise = analise;
    }

    public AnaliseBio getAnalise() {
        return this.analise;
    }

}
