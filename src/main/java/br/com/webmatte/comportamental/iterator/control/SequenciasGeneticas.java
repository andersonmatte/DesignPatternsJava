package br.com.webmatte.comportamental.iterator.control;

import br.com.webmatte.comportamental.iterator.interfaces.Iterable;

/**
 * @author Anderson Matte
 */
public class SequenciasGeneticas implements Iterable<String> {

    private final String[] sequencias;
    private final int length;

    public SequenciasGeneticas(String[] sequencias) {
        this.sequencias = sequencias;
        this.length = sequencias.length;
    }

    @Override
    public br.com.webmatte.comportamental.iterator.interfaces.Iterator<String> criarIterator() {
        return this.new SequenciasGeneticasIterator();
    }

    private class SequenciasGeneticasIterator implements br.com.webmatte.comportamental.iterator.interfaces.Iterator<String> {

        private int i = 0;

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
