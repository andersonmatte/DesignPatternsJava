package br.com.webmatte.comportamental.iterator.control;

import br.com.webmatte.comportamental.iterator.interfaces.Iterable;

import java.util.Iterator;

/**
 * @author Anderson Matte
 */
public class SequenciasGeneticas implements Iterable<String> {

    private final String[] sequencias;
    private int length;

    public SequenciasGeneticas(String[] sequencias) {
        this.sequencias = sequencias;
        this.length = sequencias.length;
    }

    @Override
    public Iterator<String> iterator() {
        return this.new SequenciasGeneticasIterator();
    }

    private class SequenciasGeneticasIterator implements Iterator<String> {

        private int i = 0;

        @Override
        public void remove() {
            SequenciasGeneticas.this.sequencias[i] = null;

            for (int j = i; (j + i) < SequenciasGeneticas.this.length; j++) {
                SequenciasGeneticas.this.sequencias[j] = SequenciasGeneticas.this.sequencias[j + 1];
            }
            SequenciasGeneticas.this.length--;
        }

        @Override
        public boolean hasNext() {
            return (this.i) < SequenciasGeneticas.this.length;
        }

        @Override
        public String next() {
            if (!hasNext()) {
                throw new java.util.NoSuchElementException("No more elements in the iteration");
            }
            return SequenciasGeneticas.this.sequencias[i++];
        }
    }

}
