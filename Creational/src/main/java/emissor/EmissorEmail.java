package emissor;

import interfaces.Emissor;

/**
 * @author Anderson Matte
 */
public class EmissorEmail implements Emissor {

    public void enviarMensagem(String mensagem) {
        System.out.println("Enviando Mensagem via Email: ");
        System.out.println(mensagem);
    }

}
