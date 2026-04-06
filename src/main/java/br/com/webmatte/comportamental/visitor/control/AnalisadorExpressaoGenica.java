package br.com.webmatte.comportamental.visitor.control;

import br.com.webmatte.comportamental.visitor.entity.GeneProteina;
import br.com.webmatte.comportamental.visitor.entity.GeneRegulador;
import br.com.webmatte.comportamental.visitor.interfaces.AnalisadorGenetico;

/**
 * @author Anderson Matte
 */
public class AnalisadorExpressaoGenica implements AnalisadorGenetico {

    @Override
    public void analisa(GeneProteina geneProteina) {
        System.out.println("Analisando gene de proteína: " + geneProteina.getNome());
        System.out.println("Proteína codificada: " + geneProteina.getProteinaCodificada());
        System.out.println("Sequência: " + geneProteina.getSequencia());
        System.out.println("Análise de expressão gênica: Nível elevado de transcrição detectado");
    }

    @Override
    public void analisa(GeneRegulador geneRegulador) {
        System.out.println("Analisando gene regulador: " + geneRegulador.getNome());
        System.out.println("Gene alvo: " + geneRegulador.getGeneAlvo());
        System.out.println("Sequência: " + geneRegulador.getSequencia());
        System.out.println("Análise regulatória: Ativação do gene alvo confirmada");
    }

}
