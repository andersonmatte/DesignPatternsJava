package br.com.webmatte.criacao.builder.interfaces;

import java.time.LocalDate;

/**
 * @author Anderson Matte
 */
public interface ProtocoloExperimental {

    String getNomePesquisador();

    String getTipoAmostra();

    Double getVolumeAmostra();

    LocalDate getDataInicio();

    Integer getDuracaoHoras();

    String getMetodoAnalise();

}
