package abstractFactory.emissor;

import abstractFactory.interfaces.Emissor;

/**
 * @author Anderson Matte
 */
public class EmissorMasterCard implements Emissor {

    @Override
    public Boolean enviaMensagem(String mensagem) {
        if (mensagem != null) {
            System.out.println("Enviando Mensagem para o Cartão Mastercard: ");
            System.out.println(mensagem);
            return true;
        } else {
            return false;
        }
    }

}
