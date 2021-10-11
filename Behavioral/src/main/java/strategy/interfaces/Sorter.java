package strategy.interfaces;

import java.util.List;

/**
 * @author Anderson Matte
 */
public interface Sorter {

    <T extends Comparable<? super T>> List<T> sort(List<T> list);

}
