package br.com.webmatte.estrutural.bridge.control;

import br.com.webmatte.estrutural.bridge.interfaces.AlgoritmoProcessamento;
import br.com.webmatte.estrutural.bridge.interfaces.AnaliseBioinformatica;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Anderson Matte
 */
public class AnaliseGenomica implements AnaliseBioinformatica {

    @Getter
    private final String nomeAnalise;
    @Getter
    private final String tipoDado;
    @Setter
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

}
