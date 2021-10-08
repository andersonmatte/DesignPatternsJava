package proxy.interfaces;

/**
 * @author Anderson Matte
 */
public interface Conta {

    void deposita(Double valorDeposito);

    void saca(Double valorSaque);

    Double getSaldo();
}
