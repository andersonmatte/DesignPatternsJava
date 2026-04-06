package br.com.webmatte.criacao.builder.gerador;

import br.com.webmatte.criacao.builder.interfaces.ProtocoloExperimental;
import br.com.webmatte.criacao.builder.interfaces.ProtocoloBuilder;

import java.time.LocalDate;

/**
 * @author Anderson Matte
 */
public class GeradorDeProtocolo {

    private ProtocoloBuilder protocoloBuilder;

    public GeradorDeProtocolo(ProtocoloBuilder protocoloBuilder) {
        this.protocoloBuilder = protocoloBuilder;
    }

    public ProtocoloExperimental getProtocolo() {
        String nomePesquisador = "Dr. Ana Silva";
        this.protocoloBuilder.buildNomePesquisador(nomePesquisador);

        String tipoAmostra = "Sangue";
        this.protocoloBuilder.buildTipoAmostra(tipoAmostra);

        Double volumeAmostra = 10.0D;
        this.protocoloBuilder.buildVolumeAmostra(volumeAmostra);

        LocalDate dataInicio = LocalDate.now();
        this.protocoloBuilder.buildDataInicio(dataInicio);

        Integer duracaoHoras = 48;
        this.protocoloBuilder.buildDuracaoHoras(duracaoHoras);

        String metodoAnalise = "Sequenciamento de DNA";
        this.protocoloBuilder.buildMetodoAnalise(metodoAnalise);

        return this.protocoloBuilder.getProtocolo();

    }

    public ProtocoloExperimental gerarProtocolo(String nomePesquisador, String tipoAmostra, 
                                               Double volumeAmostra, LocalDate dataInicio, 
                                               Integer duracaoHoras, String metodoAnalise) {
        this.protocoloBuilder.buildNomePesquisador(nomePesquisador);
        this.protocoloBuilder.buildTipoAmostra(tipoAmostra);
        this.protocoloBuilder.buildVolumeAmostra(volumeAmostra);
        this.protocoloBuilder.buildDataInicio(dataInicio);
        this.protocoloBuilder.buildDuracaoHoras(duracaoHoras);
        this.protocoloBuilder.buildMetodoAnalise(metodoAnalise);
        return protocoloBuilder.getProtocolo();
    }

}
