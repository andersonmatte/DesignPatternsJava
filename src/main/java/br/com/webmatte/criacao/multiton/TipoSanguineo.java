package br.com.webmatte.criacao.multiton;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Anderson Matte
 */
@Getter
@Setter
public class TipoSanguineo {

    public static final String TIPO_A = "A";
    public static final String TIPO_B = "B";
    public static final String TIPO_AB = "AB";
    public static final String TIPO_O = "O";

    private static Map<String, TipoSanguineo> tiposSanguineos = new HashMap<>();

    static {
        TipoSanguineo tipoA = new TipoSanguineo();
        tipoA.setNome(TipoSanguineo.TIPO_A);
        tipoA.setFatorRhPositivo(true);
        tipoA.setFatorRhNegativo(true);
        tipoA.setDoadoresPossiveis("A+, A-, O+, O-");
        tipoA.setReceptoresPossiveis("A+, AB+");
        tiposSanguineos.put(tipoA.getNome(), tipoA);

        TipoSanguineo tipoB = new TipoSanguineo();
        tipoB.setNome(TipoSanguineo.TIPO_B);
        tipoB.setFatorRhPositivo(true);
        tipoB.setFatorRhNegativo(true);
        tipoB.setDoadoresPossiveis("B+, B-, O+, O-");
        tipoB.setReceptoresPossiveis("B+, AB+");
        tiposSanguineos.put(tipoB.getNome(), tipoB);

        TipoSanguineo tipoAB = new TipoSanguineo();
        tipoAB.setNome(TipoSanguineo.TIPO_AB);
        tipoAB.setFatorRhPositivo(true);
        tipoAB.setFatorRhNegativo(true);
        tipoAB.setDoadoresPossiveis("AB+, AB-, A+, A-, B+, B-, O+, O-");
        tipoAB.setReceptoresPossiveis("AB+");
        tiposSanguineos.put(tipoAB.getNome(), tipoAB);

        TipoSanguineo tipoO = new TipoSanguineo();
        tipoO.setNome(TipoSanguineo.TIPO_O);
        tipoO.setFatorRhPositivo(true);
        tipoO.setFatorRhNegativo(true);
        tipoO.setDoadoresPossiveis("O+, O-");
        tipoO.setReceptoresPossiveis("O+, A+, B+, AB+");
        tiposSanguineos.put(tipoO.getNome(), tipoO);
    }

    private String nome;
    private boolean fatorRhPositivo;
    private boolean fatorRhNegativo;
    private String doadoresPossiveis;
    private String receptoresPossiveis;

    private TipoSanguineo() {

    }

    public static TipoSanguineo getInstance(String nome) {
        return TipoSanguineo.tiposSanguineos.get(nome);
    }

}
