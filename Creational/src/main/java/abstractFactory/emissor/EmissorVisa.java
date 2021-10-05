package abstractFactory.emissor;

import abstractFactory.interfaces.Emissor;

/**
 * @author Anderson Matte
 */
public class EmissorVisa implements Emissor {

    @Override
    public Boolean enviaMensagem(String mensagem) {
        if (mensagem != null){
            System.out.println("Enviando Mensagem para o Cartão VISA: ");
            System.out.println(mensagem);
            return true;
        } else {
            return false;
        }
    }

}
