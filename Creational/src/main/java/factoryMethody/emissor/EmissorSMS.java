package factoryMethody.emissor;

import factoryMethody.interfaces.Emissor;

/**
 * @author Anderson Matte
 */
public class EmissorSMS implements Emissor {

    public void enviarMensagem(String mensagem) {
        System.out.println("Enviando Mensagem via SMS: ");
        System.out.println(mensagem);
    }

}
