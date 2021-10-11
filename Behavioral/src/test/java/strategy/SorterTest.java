package strategy;

import org.junit.Test;
import strategy.interfaces.Sorter;
import strategy.sorter.InsertionSorter;
import strategy.sorter.SelectionSorter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Anderson Matte
 */
public class SorterTest {

    @Test
    public void testaSorter() {
        Sorter sorter = new InsertionSorter();
        List<Integer> list = new ArrayList<Integer>();
        list.add(11);
        list.add(5);
        list.add(7);
        list.add(19);

        List<Integer> list1 = sorter.sort(list);
        for (Integer integer : list1) {
            System.out.println(integer);
        }

        Sorter sorter1 = new SelectionSorter();
        List<Integer> list2 = sorter1.sort(list);
        for (Integer integer : list2) {
            System.out.println(integer);
        }

    }

}
