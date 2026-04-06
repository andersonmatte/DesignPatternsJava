package br.com.webmatte.criacao.multiton;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Anderson Matte
 */
public class TipoSanguineo {

    public static final String TIPO_A_POSITIVO = "A+";
    public static final String TIPO_A_NEGATIVO = "A-";
    public static final String TIPO_B_POSITIVO = "B+";
    public static final String TIPO_B_NEGATIVO = "B-";
    public static final String TIPO_AB_POSITIVO = "AB+";
    public static final String TIPO_AB_NEGATIVO = "AB-";
    public static final String TIPO_O_POSITIVO = "O+";
    public static final String TIPO_O_NEGATIVO = "O-";

    private static Map<String, TipoSanguineo> tiposSanguineos = new HashMap<>();
    private static int totalInstancias = 0;

    static {
        TipoSanguineo tipoAPositivo = new TipoSanguineo(TipoSanguineo.TIPO_A_POSITIVO);
        tiposSanguineos.put(tipoAPositivo.getTipo(), tipoAPositivo);

        TipoSanguineo tipoANegativo = new TipoSanguineo(TipoSanguineo.TIPO_A_NEGATIVO);
        tiposSanguineos.put(tipoANegativo.getTipo(), tipoANegativo);

        TipoSanguineo tipoBPositivo = new TipoSanguineo(TipoSanguineo.TIPO_B_POSITIVO);
        tiposSanguineos.put(tipoBPositivo.getTipo(), tipoBPositivo);

        TipoSanguineo tipoBNegativo = new TipoSanguineo(TipoSanguineo.TIPO_B_NEGATIVO);
        tiposSanguineos.put(tipoBNegativo.getTipo(), tipoBNegativo);

        TipoSanguineo tipoABPositivo = new TipoSanguineo(TipoSanguineo.TIPO_AB_POSITIVO);
        tiposSanguineos.put(tipoABPositivo.getTipo(), tipoABPositivo);

        TipoSanguineo tipoABNegativo = new TipoSanguineo(TipoSanguineo.TIPO_AB_NEGATIVO);
        tiposSanguineos.put(tipoABNegativo.getTipo(), tipoABNegativo);

        TipoSanguineo tipoOPositivo = new TipoSanguineo(TipoSanguineo.TIPO_O_POSITIVO);
        tiposSanguineos.put(tipoOPositivo.getTipo(), tipoOPositivo);

        TipoSanguineo tipoONegativo = new TipoSanguineo(TipoSanguineo.TIPO_O_NEGATIVO);
        tiposSanguineos.put(tipoONegativo.getTipo(), tipoONegativo);
    }

    private String tipo;
    private String informacao;

    private TipoSanguineo(String tipo) {
        this.tipo = tipo;
        this.informacao = "";
        totalInstancias++;
    }

    public static TipoSanguineo getInstance(String tipo) {
        if (!tiposSanguineos.containsKey(tipo)) {
            throw new IllegalArgumentException("Tipo sanguíneo inválido: " + tipo);
        }
        return tiposSanguineos.get(tipo);
    }

    public static int getTotalInstancias() {
        return totalInstancias;
    }

    public String getTipo() {
        return tipo;
    }

    public boolean isPositivo() {
        return tipo.endsWith("+");
    }

    public String getInformacao() {
        return informacao;
    }

    public void setInformacao(String informacao) {
        this.informacao = informacao;
    }
}
