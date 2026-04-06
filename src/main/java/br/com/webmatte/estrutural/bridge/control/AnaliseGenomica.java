package br.com.webmatte.estrutural.bridge.control;

import br.com.webmatte.estrutural.bridge.interfaces.AlgoritmoProcessamento;
import br.com.webmatte.estrutural.bridge.interfaces.AnaliseBioinformatica;

/**
 * @author Anderson Matte
 */
public class AnaliseGenomica implements AnaliseBioinformatica {

    private String nomeAnalise;
    private String tipoDado;
    private AlgoritmoProcessamento algoritmoProcessamento;

    public AnaliseGenomica(String nomeAnalise, String tipoDado, AlgoritmoProcessamento algoritmoProcessamento) {
        this.nomeAnalise = nomeAnalise;
        this.tipoDado = tipoDado;
        this.algoritmoProcessamento = algoritmoProcessamento;
    }

    @Override
    public void executarAnalise() {
        String dados = "Análise Genômica: " + nomeAnalise +
                "\nTipo de Dado: " + tipoDado +
                "\nProcessando sequências genéticas...";
        this.algoritmoProcessamento.processarDados(dados);
    }

    public void executarAnalise(String dados) {
        String dadosCompletos = "Análise Genômica: " + nomeAnalise +
                "\nTipo de Dado: " + tipoDado +
                "\nProcessando dados genéticos..." +
                "\nDados: " + dados;
        this.algoritmoProcessamento.processarDados(dadosCompletos);
    }

    public void setAlgoritmoProcessamento(AlgoritmoProcessamento algoritmoProcessamento) {
        this.algoritmoProcessamento = algoritmoProcessamento;
    }

    public String getNomeAnalise() {
        return nomeAnalise;
    }

    public String getTipoDado() {
        return tipoDado;
    }

}
