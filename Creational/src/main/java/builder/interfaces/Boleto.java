package builder.interfaces;

import java.time.LocalDate;

/**
 * @author Anderson Matte
 */
public interface Boleto {

    String getSacado();

    String getCedente();

    Double getValor();

    LocalDate getVencimento();

    Integer getNossoNumero();

}
