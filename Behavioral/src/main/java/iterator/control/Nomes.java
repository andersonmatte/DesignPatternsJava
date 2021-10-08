package iterator.control;

import iterator.interfaces.Iterable;

import java.util.Iterator;

/**
 * @author Anderson Matte
 */
public class Nomes implements Iterable<String> {

    private String[] nomes;
    private int length;

    public Nomes(String[] nomes) {
        this.nomes = nomes;
    }

    @Override
    public Iterator<String> iterator() {
        return this.new ListaNomesIterator();
    }

    private class ListaNomesIterator implements Iterator<String> {

        private int i = 0;

        public void remove() {
            Nomes.this.nomes[i] = null;

            for (int j = i; (j + i) < Nomes.this.length; j++) {
                Nomes.this.nomes[j] = Nomes.this.nomes[j + 1];
            }
            Nomes.this.length--;
        }

        @Override
        public boolean hasNext() {
            return (this.i) < Nomes.this.length;
        }

        @Override
        public String next() {
            return Nomes.this.nomes[i++];
        }
    }

}
