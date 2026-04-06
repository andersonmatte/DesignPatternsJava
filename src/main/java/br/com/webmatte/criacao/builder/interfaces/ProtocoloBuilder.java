package br.com.webmatte.criacao.builder.interfaces;

import java.time.LocalDate;

/**
 * @author Anderson Matte
 */
public interface ProtocoloBuilder {

    void buildNomePesquisador(String nomePesquisador);

    void buildTipoAmostra(String tipoAmostra);

    void buildVolumeAmostra(Double volumeAmostra);

    void buildDataInicio(LocalDate dataInicio);

    void buildDuracaoHoras(Integer duracaoHoras);

    void buildMetodoAnalise(String metodoAnalise);

    ProtocoloExperimental getProtocolo();

}
