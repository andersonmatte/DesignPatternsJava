package builder.bancos;

import builder.boletos.ItauBoleto;
import builder.interfaces.Boleto;
import builder.interfaces.BoletoBuilder;

import java.time.LocalDate;

/**
 * @author Anderson Matte
 */
public class ItauBuilder implements BoletoBuilder {

    private String sacado;
    private String cedente;
    private Double valor;
    private LocalDate vencimento;
    private Integer nossoNumero;

    @Override
    public void buildSacado(String sacado) {
        this.sacado = sacado;
    }

    @Override
    public void buildCedente(String cedente) {
        this.cedente = cedente;
    }

    @Override
    public void buildValor(Double valor) {
        this.valor = valor;
    }

    @Override
    public void buildVencimento(LocalDate vencimento) {
        this.vencimento = vencimento;
    }

    @Override
    public void buildNossoNumero(Integer nossoNumero) {
        this.nossoNumero = nossoNumero;
    }

    @Override
    public Boleto getBoleto() {
        return new ItauBoleto(this.sacado, this.cedente, this.valor, this.vencimento, this.nossoNumero);
    }

}
