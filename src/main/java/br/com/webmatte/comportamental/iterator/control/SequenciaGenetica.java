package br.com.webmatte.comportamental.iterator.control;

import br.com.webmatte.comportamental.iterator.interfaces.Iterable;
import br.com.webmatte.comportamental.iterator.interfaces.Iterator;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * @author Anderson Matte
 */
public class SequenciaGenetica implements Iterable<String> {

    private final List<String> genes;

    public SequenciaGenetica() {
        this.genes = new ArrayList<>();
    }

    public void adicionarGene(String gene) {
        genes.add(gene);
    }

    @Override
    public Iterator<String> criarIterator() {
        return new SequenciaGeneticaIterator();
    }

    private class SequenciaGeneticaIterator implements Iterator<String> {

        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < genes.size();
        }

        @Override
        public String next() {
            if (!hasNext()) {
                throw new NoSuchElementException("No more elements in the iteration");
            }
            return genes.get(currentIndex++);
        }
    }
}
