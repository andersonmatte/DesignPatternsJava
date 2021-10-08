package proxy.control;

import proxy.interfaces.Conta;

/**
 * @author Anderson Matte
 */
public class ContaProxy implements Conta {

    private Conta conta;

    public ContaProxy(Conta conta) {
        this.conta = conta;
    }

    @Override
    public void deposita(Double valorDeposito) {
        System.out.println("Efetuando o depósito de R$ " + valorDeposito + "...");
        this.conta.deposita(valorDeposito);
        System.out.println("Depósito de R$ " + valorDeposito + " efetuado");
    }

    @Override
    public void saca(Double valorSaque) {
        System.out.println("Saque de R$ " + valorSaque + " efetuado");
        this.conta.saca(valorSaque);
    }

    @Override
    public Double getSaldo() {
        System.out.println("Verificando o saldo...");
        return this.conta.getSaldo();
    }

}
