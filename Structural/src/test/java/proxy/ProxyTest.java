package proxy;

import org.junit.Test;
import proxy.control.ContaCorrente;
import proxy.control.ContaProxy;
import proxy.interfaces.Conta;

/**
 * @author Anderson Matte
 */
public class ProxyTest {

    ContaCorrente contaCorrente = new ContaCorrente();
    Conta contaProxy = new ContaProxy(contaCorrente);

    @Test
    public void testaDeposito() {
        contaProxy.deposita(199D);
        this.testaSaque();
    }

    public void testaSaque() {
        contaProxy.saca(39D);
        this.testaSaldo();
    }

    public void testaSaldo() {
        System.out.println("Saldo: " + contaProxy.getSaldo());
    }

}
