package br.com.webmatte.comportamental.visitor.visitor;

import br.com.webmatte.comportamental.visitor.entity.GeneProteina;
import br.com.webmatte.comportamental.visitor.entity.GeneRegulador;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Anderson Matte
 */
public class AnalisadorMolecular {

    private final List<String> genesAnalisados;
    private StringBuilder resultado;

    public AnalisadorMolecular() {
        this.resultado = new StringBuilder();
        this.genesAnalisados = new ArrayList<>();
    }

    public void visitaGeneProteina(GeneProteina gene) {
        resultado.append("Analisando gene de proteína\n");
        resultado.append("Nome: ").append(gene.getNome()).append("\n");
        resultado.append("Sequência: ").append(gene.getSequencia()).append("\n");
        resultado.append("Estrutura terciária: Predita\n");
        resultado.append("Função: Transporte de oxigênio\n");
        resultado.append("\n");

        genesAnalisados.add(gene.getNome());
    }

    public void visitaGeneRegulador(GeneRegulador gene) {
        resultado.append("Analisando gene regulador\n");
        resultado.append("Nome: ").append(gene.getNome()).append("\n");
        resultado.append("Sequência: ").append(gene.getSequencia()).append("\n");
        resultado.append("Sítios de ligação: Identificados\n");
        resultado.append("Regulação: Supressora de tumor\n");
        resultado.append("\n");

        genesAnalisados.add(gene.getNome());
    }

    public String getResultado() {
        return resultado.toString();
    }

    public List<String> getGenesAnalisados() {
        return new ArrayList<>(genesAnalisados);
    }

    public int getTotalGenesAnalisados() {
        return genesAnalisados.size();
    }

    public void resetar() {
        resultado = new StringBuilder();
        genesAnalisados.clear();
    }
}
