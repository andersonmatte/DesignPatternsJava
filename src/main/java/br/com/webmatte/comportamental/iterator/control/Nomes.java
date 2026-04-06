package br.com.webmatte.comportamental.iterator.control;

import br.com.webmatte.comportamental.iterator.interfaces.Iterable;

import java.util.Iterator;

/**
 * @author Anderson Matte
 */
public class Nomes implements Iterable<String> {

    private final String[] nomeslistaNomes;
    private int length;

    public Nomes(String[] nomeslistaNomes) {
        this.nomeslistaNomes = nomeslistaNomes;
    }

    @Override
    public Iterator<String> iterator() {
        return this.new ListaNomesIterator();
    }

    private class ListaNomesIterator implements Iterator<String> {

        private int i = 0;

        @Override
        public void remove() {
            Nomes.this.nomeslistaNomes[i] = null;

            for (int j = i; (j + i) < Nomes.this.length; j++) {
                Nomes.this.nomeslistaNomes[j] = Nomes.this.nomeslistaNomes[j + 1];
            }
            Nomes.this.length--;
        }

        @Override
        public boolean hasNext() {
            return (this.i) < Nomes.this.length;
        }

        @Override
        public String next() {
            if (!hasNext()) {
                throw new java.util.NoSuchElementException("No more elements in the iteration");
            }
            return Nomes.this.nomeslistaNomes[i++];
        }
    }

}
