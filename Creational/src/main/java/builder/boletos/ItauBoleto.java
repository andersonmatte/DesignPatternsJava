package builder.boletos;

import builder.interfaces.Boleto;

import java.time.LocalDate;

/**
 * @author Anderson Matte
 */
public class ItauBoleto implements Boleto {

    private String sacado;
    private String cedente;
    private Double valor;
    private LocalDate vencimento;
    private Integer nossoNumero;

    public ItauBoleto(String sacado, String cedente, Double valor, LocalDate vencimento, Integer nossoNumero) {
        this.sacado = sacado;
        this.cedente = cedente;
        this.valor = valor;
        this.vencimento = vencimento;
        this.nossoNumero = nossoNumero;
    }

    @Override
    public String getSacado() {
        return this.sacado = sacado;
    }

    @Override
    public String getCedente() {
        return this.cedente = cedente;
    }

    @Override
    public Double getValor() {
        return this.valor = valor;
    }

    @Override
    public LocalDate getVencimento() {
        return this.vencimento = vencimento;
    }

    @Override
    public Integer getNossoNumero() {
        return this.nossoNumero = nossoNumero;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Boleto Itaú\n");
        stringBuilder.append("Sacado: " + this.sacado + "\n");
        stringBuilder.append("Cedente: " + this.cedente + "\n");
        stringBuilder.append("Valor: " + this.valor + "\n");
        stringBuilder.append("Vencimento: " + this.vencimento + "\n");
        stringBuilder.append("Nosso Número: " + this.nossoNumero + "\n");
        return stringBuilder.toString();
    }

}
