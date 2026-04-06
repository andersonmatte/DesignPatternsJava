package br.com.webmatte.criacao.builder.genetica;

import br.com.webmatte.criacao.builder.interfaces.ProtocoloExperimental;

import java.time.LocalDate;

/**
 * @author Anderson Matte
 */
public class ProtocoloGenetica implements ProtocoloExperimental {

    private String nomePesquisador;
    private String tipoAmostra;
    private Double volumeAmostra;
    private LocalDate dataInicio;
    private Integer duracaoHoras;
    private String metodoAnalise;

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
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Protocolo de Genética\n");
        stringBuilder.append("Pesquisador: " + this.nomePesquisador + "\n");
        stringBuilder.append("Tipo Amostra: " + this.tipoAmostra + "\n");
        stringBuilder.append("Volume Amostra: " + this.volumeAmostra + " mL\n");
        stringBuilder.append("Data Início: " + this.dataInicio + "\n");
        stringBuilder.append("Duração: " + this.duracaoHoras + " horas\n");
        stringBuilder.append("Método Análise: " + this.metodoAnalise + "\n");
        return stringBuilder.toString();
    }

}
