package br.com.webmatte.comportamental.strategy.sorter;

import br.com.webmatte.comportamental.strategy.interfaces.AlgoritmoAlinhamento;

/**
 * @author Anderson Matte
 */
public class AlinhamentoGlobal implements AlgoritmoAlinhamento {

    @Override
    public String alinharSequencias(String sequencia1, String sequencia2) {
        // Simplificação do algoritmo Needleman-Wunsch para alinhamento global
        StringBuilder resultado = new StringBuilder();
        resultado.append("Alinhamento Global (Needleman-Wunsch):\n");
        resultado.append("Sequência 1: ").append(sequencia1).append("\n");
        resultado.append("Sequência 2: ").append(sequencia2).append("\n");

        // Simulação de alinhamento com gaps
        int maxLength = Math.max(sequencia1.length(), sequencia2.length());
        for (int i = 0; i < maxLength; i++) {
            char c1 = i < sequencia1.length() ? sequencia1.charAt(i) : '-';
            char c2 = i < sequencia2.length() ? sequencia2.charAt(i) : '-';
            resultado.append(c1).append(" ").append(c2).append(" ");
            if (c1 == c2) resultado.append("| ");
            else resultado.append("  ");
        }

        return resultado.toString();
    }

}
