package templateMethod;

import org.junit.Test;
import templateMethod.entity.ContaCorrente;
import templateMethod.entity.ContaPoupanca;

/**
 * @author Anderson Matte
 */
public class ContaTest {

    @Test
    public void testaContaCorrente() {
        ContaCorrente contaCorrente = new ContaCorrente();
        contaCorrente.deposita(1000D);
        contaCorrente.saca(19D);
        System.out.println(" O saldo da Conta Corrente é: " + contaCorrente.getSaldo());
    }

    @Test
    public void testaContaPoupanca() {
        ContaPoupanca contaPoupanca = new ContaPoupanca();
        contaPoupanca.deposita(869D);
        contaPoupanca.saca(78D);
        System.out.println(" O saldo da Conta Poupança é: " + contaPoupanca.getSaldo());
    }

}
