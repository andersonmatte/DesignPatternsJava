package br.com.webmatte.estrutural.facade.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Anderson Matte
 */
@Getter
@Setter
public class AnaliseGenomica {

    private String codigoAmostra;
    private String tipoAnalise;
    private String nomePaciente;
    private String dataColeta;

    public AnaliseGenomica(String codigoAmostra, String tipoAnalise, String nomePaciente, String dataColeta) {
        this.codigoAmostra = codigoAmostra;
        this.tipoAnalise = tipoAnalise;
        this.nomePaciente = nomePaciente;
        this.dataColeta = dataColeta;
    }

}
