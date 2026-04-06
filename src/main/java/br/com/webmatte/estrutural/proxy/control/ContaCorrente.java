package br.com.webmatte.estrutural.proxy.control;

import br.com.webmatte.estrutural.proxy.interfaces.Conta;

/**
 * @author Anderson Matte
 */
public class ContaCorrente implements Conta {

    private Double saldo = 0D;

    @Override
    public void deposita(Double valorDeposito) {
        this.saldo += valorDeposito;
    }

    @Override
    public void saca(Double valorSaque) {
        this.saldo -= valorSaque;
    }

    @Override
    public Double getSaldo() {
        return this.saldo;
    }

}
