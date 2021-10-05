package abstractFactory;

import abstractFactory.factory.MasterCardFactory;
import abstractFactory.interfaces.ComunicadorFactory;
import abstractFactory.interfaces.Emissor;
import abstractFactory.interfaces.Receptor;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Anderson Matte
 */
public class MasterCarFactoryTest {

    ComunicadorFactory comunicadorFactory = new MasterCardFactory();

    @Test
    public void testaEmissor(){
        String valorDebito = "Valor=459,99";
        Emissor emissor = comunicadorFactory.createEmissor();
        Assert.assertTrue(emissor.enviaMensagem(valorDebito));
    }

    @Test
    public void testaReceptor(){
        Receptor receptor = comunicadorFactory.createRceptor();
        Assert.assertEquals( "Mensagem Cartão MasterCard", receptor.recebeBandeiraCartao());
    }

}
