package builder.interfaces;

import java.time.LocalDate;

/**
 * @author Anderson Matte
 */
public interface BoletoBuilder {

    void buildSacado(String sacado);

    void buildCedente(String cedente);

    void buildValor(Double valor);

    void buildVencimento(LocalDate vencimento);

    void buildNossoNumero(Integer nossoNumero);

    Boleto getBoleto();

}
