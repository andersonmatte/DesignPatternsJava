package builder.gerador;

import builder.interfaces.Boleto;
import builder.interfaces.BoletoBuilder;

import java.time.LocalDate;

/**
 * @author Anderson Matte
 */
public class GeradorDeBoleto {

    private BoletoBuilder boletoBuilder;

    public GeradorDeBoleto(BoletoBuilder boletoBuilder) {
        this.boletoBuilder = boletoBuilder;
    }

    public Boleto getBoleto() {
        String sacado = "Anderson Matte";
        this.boletoBuilder.buildSacado(sacado);

        String cedente = "Ponto Frio";
        this.boletoBuilder.buildCedente(cedente);

        Double valor = 350.00D;
        this.boletoBuilder.buildValor(valor);

        LocalDate vencimento = LocalDate.now();
        this.boletoBuilder.buildVencimento(vencimento);

        Integer nossoNumero = 12456;
        this.boletoBuilder.buildNossoNumero(nossoNumero);

        return this.boletoBuilder.getBoleto();

    }

    public Boleto gerarBoleto(String sacado, String cedente, Double valor, LocalDate vencimento, Integer nossoNumero) {
        this.boletoBuilder.buildSacado(sacado);
        this.boletoBuilder.buildCedente(cedente);
        this.boletoBuilder.buildValor(valor);
        this.boletoBuilder.buildVencimento(vencimento);
        this.boletoBuilder.buildNossoNumero(nossoNumero);
        Boleto boleto = boletoBuilder.getBoleto();
        return boleto;
    }


}
