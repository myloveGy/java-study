package collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ArrayListTest {

    @Test
    public void test() {
        String name = "123进行";
        System.out.println(name.length());

        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        updateList(list);
        System.out.println(list);
    }

    public void updateList(List list) {
        list.remove(new Integer(2));
    }
}
