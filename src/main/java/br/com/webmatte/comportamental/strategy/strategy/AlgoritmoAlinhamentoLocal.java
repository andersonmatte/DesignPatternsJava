package br.com.webmatte.comportamental.strategy.strategy;

import br.com.webmatte.comportamental.strategy.interfaces.AlgoritmoAlinhamento;

/**
 * @author Anderson Matte
 */
public class AlgoritmoAlinhamentoLocal implements AlgoritmoAlinhamento {

    @Override
    public String alinharSequencias(String sequencia1, String sequencia2) {
        // Simplificação do algoritmo Smith-Waterman para alinhamento local
        StringBuilder resultado = new StringBuilder();
        resultado.append("Alinhamento Local (Smith-Waterman):\n");
        resultado.append("Sequência 1: ").append(sequencia1).append("\n");
        resultado.append("Sequência 2: ").append(sequencia2).append("\n");

        // Simulação de alinhamento local - encontra melhor subsequência comum
        String melhorSubsequencia = encontrarMelhorSubsequencia(sequencia1, sequencia2);
        resultado.append("Melhor alinhamento local: ").append(melhorSubsequencia).append("\n");

        return resultado.toString();
    }

    private String encontrarMelhorSubsequencia(String seq1, String seq2) {
        String melhor = "";
        int maxLength = Math.min(seq1.length(), seq2.length());

        for (int i = 0; i <= seq1.length() - maxLength; i++) {
            for (int j = 0; j <= seq2.length() - maxLength; j++) {
                String subseq1 = seq1.substring(i, Math.min(i + maxLength, seq1.length()));
                String subseq2 = seq2.substring(j, Math.min(j + maxLength, seq2.length()));

                if (subseq1.equals(subseq2) && subseq1.length() > melhor.length()) {
                    melhor = subseq1;
                }
            }
        }

        return melhor.isEmpty() ? "Nenhuma correspondência significativa encontrada" : melhor;
    }

    public String alinhar(String sequencia1, String sequencia2) {
        return alinharSequencias(sequencia1, sequencia2);
    }
}
