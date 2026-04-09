package br.com.webmatte.criacao.builder.genetica;

import br.com.webmatte.criacao.builder.interfaces.ProtocoloExperimental;

import java.time.LocalDate;

/**
 * @author Anderson Matte
 */
public class ProtocoloGenetica implements ProtocoloExperimental {

    private final String nomePesquisador;
    private final String tipoAmostra;
    private final Double volumeAmostra;
    private final LocalDate dataInicio;
    private final Integer duracaoHoras;
    private final String metodoAnalise;

    public ProtocoloGenetica(String nomePesquisador, String tipoAmostra, Double volumeAmostra,
                             LocalDate dataInicio, Integer duracaoHoras, String metodoAnalise) {
        this.nomePesquisador = nomePesquisador;
        this.tipoAmostra = tipoAmostra;
        this.volumeAmostra = volumeAmostra;
        this.dataInicio = dataInicio;
        this.duracaoHoras = duracaoHoras;
        this.metodoAnalise = metodoAnalise;
    }

    @Override
    public String getNomePesquisador() {
        return this.nomePesquisador;
    }

    @Override
    public String getTipoAmostra() {
        return this.tipoAmostra;
    }

    @Override
    public Double getVolumeAmostra() {
        return this.volumeAmostra;
    }

    @Override
    public LocalDate getDataInicio() {
        return this.dataInicio;
    }

    @Override
    public Integer getDuracaoHoras() {
        return this.duracaoHoras;
    }

    @Override
    public String getMetodoAnalise() {
        return this.metodoAnalise;
    }

    public String toString() {
        return "Protocolo de Genética\n" +
                "Pesquisador: " + this.nomePesquisador + "\n" +
                "Tipo Amostra: " + this.tipoAmostra + "\n" +
                "Volume Amostra: " + this.volumeAmostra + " mL\n" +
                "Data Início: " + this.dataInicio + "\n" +
                "Duração: " + this.duracaoHoras + " horas\n" +
                "Método Análise: " + this.metodoAnalise + "\n";
    }

}
