package decorator.control;

import decorator.interfaces.Emissor;

/**
 * @author Anderson Matte
 */
public class EmissorSimples implements Emissor {

    @Override
    public void envia(String mensagem) {
        System.out.println("Enviando a mensagem: ");
        System.out.println(mensagem);
    }

}
