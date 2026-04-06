package br.com.webmatte.criacao.builder.protocolo;

import br.com.webmatte.criacao.builder.genetica.ProtocoloGenetica;
import br.com.webmatte.criacao.builder.interfaces.ProtocoloBuilder;
import br.com.webmatte.criacao.builder.interfaces.ProtocoloExperimental;

import java.time.LocalDate;

/**
 * @author Anderson Matte
 */
public class ProtocoloGeneticaBuilder implements ProtocoloBuilder {

    private String nomePesquisador;
    private String tipoAmostra;
    private Double volumeAmostra;
    private LocalDate dataInicio;
    private Integer duracaoHoras;
    private String metodoAnalise;

    @Override
    public void buildNomePesquisador(String nomePesquisador) {
        this.nomePesquisador = nomePesquisador;
    }

    @Override
    public void buildTipoAmostra(String tipoAmostra) {
        this.tipoAmostra = tipoAmostra;
    }

    @Override
    public void buildVolumeAmostra(Double volumeAmostra) {
        this.volumeAmostra = volumeAmostra;
    }

    @Override
    public void buildDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    @Override
    public void buildDuracaoHoras(Integer duracaoHoras) {
        this.duracaoHoras = duracaoHoras;
    }

    @Override
    public void buildMetodoAnalise(String metodoAnalise) {
        this.metodoAnalise = metodoAnalise;
    }

    @Override
    public ProtocoloExperimental getProtocolo() {
        return new ProtocoloGenetica(this.nomePesquisador, this.tipoAmostra, this.volumeAmostra,
                this.dataInicio, this.duracaoHoras, this.metodoAnalise);
    }

}
