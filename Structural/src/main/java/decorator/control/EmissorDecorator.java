package decorator.control;

import decorator.interfaces.Emissor;

/**
 * @author Anderson Matte
 */
public class EmissorDecorator implements Emissor {

    private Emissor emissor;

    public EmissorDecorator(Emissor emissor) {
        this.emissor = emissor;
    }

    @Override
    public void envia(String mensagem) {

    }

    public Emissor getEmissor() {
        return this.emissor;
    }

}
