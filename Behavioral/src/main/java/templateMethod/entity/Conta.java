package templateMethod.entity;

/**
 * @author Anderson Matte
 */
public abstract class Conta {

    private Double saldo = 0D;

    public void deposita(Double valor) {
        this.saldo += valor;
        this.saldo -= this.calculaValorTaxa();
    }

    public void saca(Double valor) {
        this.saldo -= valor;
        this.saldo -= this.calculaValorTaxa();
    }

    public Double getSaldo() {
        return saldo;
    }

    public abstract Double calculaValorTaxa();

}
