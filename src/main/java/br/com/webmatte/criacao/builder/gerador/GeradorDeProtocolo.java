package br.com.webmatte.criacao.builder.gerador;

import br.com.webmatte.criacao.builder.interfaces.ProtocoloBuilder;
import br.com.webmatte.criacao.builder.interfaces.ProtocoloExperimental;

import java.time.LocalDate;

/**
 * @author Anderson Matte
 */
public class GeradorDeProtocolo {

    private ProtocoloBuilder protocoloBuilder;
    private String nomePesquisador;
    private String tipoAmostra;
    private Double volumeAmostra;
    private LocalDate dataInicio;
    private Integer duracaoHoras;
    private String metodoAnalise;

    public GeradorDeProtocolo() {
        // Default constructor for testing
    }

    public GeradorDeProtocolo(ProtocoloBuilder protocoloBuilder) {
        this.protocoloBuilder = protocoloBuilder;
    }

    public GeradorDeProtocolo comNomePesquisador(String nomePesquisador) {
        this.nomePesquisador = nomePesquisador;
        return this;
    }

    public GeradorDeProtocolo comTipoAmostra(String tipoAmostra) {
        this.tipoAmostra = tipoAmostra;
        return this;
    }

    public GeradorDeProtocolo comVolumeAmostra(Double volumeAmostra) {
        this.volumeAmostra = volumeAmostra;
        return this;
    }

    public GeradorDeProtocolo comDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
        return this;
    }

    public GeradorDeProtocolo comDuracaoHoras(Integer duracaoHoras) {
        this.duracaoHoras = duracaoHoras;
        return this;
    }

    public GeradorDeProtocolo comMetodoAnalise(String metodoAnalise) {
        this.metodoAnalise = metodoAnalise;
        return this;
    }

    public ProtocoloExperimental getProtocolo() {
        // Create a simple implementation for testing
        return new ProtocoloExperimental() {
            private final String nome = nomePesquisador != null ? nomePesquisador : "Dr. Ana Silva";
            private final String tipo = tipoAmostra != null ? tipoAmostra : "Sangue";
            private final Double volume = volumeAmostra != null ? volumeAmostra : 10.0;
            private final LocalDate data = dataInicio != null ? dataInicio : LocalDate.now();
            private final Integer duracao = duracaoHoras != null ? duracaoHoras : 48;
            private final String metodo = metodoAnalise != null ? metodoAnalise : "Sequenciamento de DNA";

            @Override
            public String getNomePesquisador() {
                return nome;
            }

            @Override
            public String getTipoAmostra() {
                return tipo;
            }

            @Override
            public Double getVolumeAmostra() {
                return volume;
            }

            @Override
            public LocalDate getDataInicio() {
                return data;
            }

            @Override
            public Integer getDuracaoHoras() {
                return duracao;
            }

            @Override
            public String getMetodoAnalise() {
                return metodo;
            }

            @Override
            public String toString() {
                return "ProtocoloExperimental{" +
                        "nomePesquisador='" + nome + '\'' +
                        ", tipoAmostra='" + tipo + '\'' +
                        ", volumeAmostra=" + volume +
                        ", dataInicio=" + data +
                        ", duracaoHoras=" + duracao +
                        ", metodoAnalise='" + metodo + '\'' +
                        '}';
            }
        };
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
