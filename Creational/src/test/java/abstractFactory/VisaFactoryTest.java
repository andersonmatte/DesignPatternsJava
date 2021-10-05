package abstractFactory;

import abstractFactory.factory.VisaFactory;
import abstractFactory.interfaces.ComunicadorFactory;
import abstractFactory.interfaces.Emissor;
import abstractFactory.interfaces.Receptor;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Anderson Matte
 */
public class VisaFactoryTest {

    ComunicadorFactory comunicadorFactory = new VisaFactory();

    @Test
    public void testaEmissor(){
        String valorDebito = "Valor=356,02";
        Emissor emissor = comunicadorFactory.createEmissor();
        Assert.assertTrue(emissor.enviaMensagem(valorDebito));
    }

    @Test
    public void testaReceptor(){
        Receptor receptor = comunicadorFactory.createRceptor();
        Assert.assertEquals( "Mensagem Cartão VISA", receptor.recebeBandeiraCartao());
    }

}
