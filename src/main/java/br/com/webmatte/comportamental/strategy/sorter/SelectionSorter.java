package br.com.webmatte.comportamental.strategy.sorter;

import br.com.webmatte.comportamental.strategy.interfaces.Sorter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Anderson Matte
 */
public class SelectionSorter implements Sorter {

    @Override
    public <T extends Comparable<? super T>> List<T> sort(List<T> list) {
        int indexMin;
        T aux;
        list = new ArrayList<>(list);

        for (int i = 0; i < list.size(); i++) {
            indexMin = i;
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(j).compareTo(list.get(indexMin)) > 0) {
                    indexMin = j;
                }
            }
            if (indexMin != i) {
                aux = list.get(indexMin);
                T temp = list.get(i);
                list.set(indexMin, temp);
                list.set(i, aux);
            }
        }
        return list;
    }

}
