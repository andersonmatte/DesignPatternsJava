package br.com.webmatte.estrutural.proxy.control;

import br.com.webmatte.estrutural.proxy.interfaces.Conta;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Anderson Matte
 */
@Slf4j
public class ContaProxy implements Conta {

    private Conta conta;

    public ContaProxy(Conta conta) {
        this.conta = conta;
    }

    @Override
    public void deposita(Double valorDeposito) {
        log.info("Efetuando o depósito de R$ " + valorDeposito + "...");
        this.conta.deposita(valorDeposito);
        log.info("Depósito de R$ " + valorDeposito + " efetuado");
    }

    @Override
    public void saca(Double valorSaque) {
        log.info("Saque de R$ " + valorSaque + " efetuado");
        this.conta.saca(valorSaque);
    }

    @Override
    public Double getSaldo() {
        log.info("Verificando o saldo...");
        return this.conta.getSaldo();
    }

}
