package br.com.webmatte.estrutural.decorator.control;

import br.com.webmatte.estrutural.decorator.interfaces.AnaliseBio;
import lombok.Getter;

/**
 * @author Anderson Matte
 */
@Getter
public abstract class AnaliseDecorator implements AnaliseBio {

    protected AnaliseBio analise;

    protected AnaliseDecorator(AnaliseBio analise) {
        this.analise = analise;
    }

}
