package singlenton;

import org.junit.Test;

/**
 * @author Anderson Matte
 */
public class ConfiguracaoTest {

    @Test
    public void testaConfiguracao(){
        Configuracao configuracao = Configuracao.getInstance();
        System.out.println(configuracao.getProperties("time-zone"));
        System.out.println(configuracao.getProperties("currency-code"));
    }

}
