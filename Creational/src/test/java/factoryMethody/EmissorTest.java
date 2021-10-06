package factoryMethody;

import factoryMethody.emissor.EmissorEmail;
import factoryMethody.emissor.EmissorSMS;
import factoryMethody.interfaces.Emissor;
import org.junit.Test;

/**
 * @author Anderson Matte
 */
public class EmissorTest {

    @Test
    public void testaEmissorSMS() {
        Emissor emissorSMS = new EmissorSMS();
        emissorSMS.enviarMensagem("Teste de envio de SMS...");
    }

    @Test
    public void testaEmissorEmail() {
        Emissor emissorEmail = new EmissorEmail();
        emissorEmail.enviarMensagem("Teste de envio de Email...");
    }

}
