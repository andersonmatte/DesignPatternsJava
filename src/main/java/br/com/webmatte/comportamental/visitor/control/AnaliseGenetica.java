package br.com.webmatte.comportamental.visitor.control;

import br.com.webmatte.comportamental.visitor.interfaces.ElementoGenetico;
import br.com.webmatte.comportamental.visitor.visitor.AnalisadorMolecular;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Anderson Matte
 */
public class AnaliseGenetica {

    private List<ElementoGenetico> genes;

    public AnaliseGenetica() {
        this.genes = new ArrayList<>();
    }

    public void adicionarGene(ElementoGenetico gene) {
        genes.add(gene);
    }

    public String executarAnaliseGenomica() {
        StringBuilder resultado = new StringBuilder();
        resultado.append("Iniciando análise genômica\n");

        AnalisadorMolecular analisador = new AnalisadorMolecular();

        for (ElementoGenetico gene : genes) {
            gene.aceitar(analisador);
        }

        resultado.append(analisador.getResultado());
        resultado.append("Análise genômica concluída\n");

        return resultado.toString();
    }
}
