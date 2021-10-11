package strategy.sorter;

import strategy.interfaces.Sorter;

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
        list = new ArrayList<T>(list);

        for (int i = 0; i < list.size(); i++) {
            indexMin = i;
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(j).compareTo(list.get(indexMin)) > 0) {
                    indexMin = j;
                }
            }
            if (indexMin != i) {
                aux = list.get(indexMin);
                list.remove(indexMin);
                list.add(indexMin, list.get(i));
                list.remove(i);
                list.add(i, aux);
            }
        }
        return list;
    }

}
