package bridge;

import bridge.control.GeradorDeArquivoTXT;
import bridge.control.Recibo;
import org.junit.Test;

/**
 * @author Anderson Matte
 */
public class ReciboTest {

    @Test
    public void testaRecibo() {
        Recibo recibo = new Recibo("Casas Bahia", "Anderson Matte", 1499.99D, new GeradorDeArquivoTXT());
        recibo.gerarArquivo();
    }

}
