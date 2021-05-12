package generic;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class GenericTest {

    @Test
    public void test() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(100);
        list.add(98);
        list.add(96);
        list.add(88);
        System.out.println(list);
        for (Integer i: list) {
            System.out.println(i);
        }
    }

    @Test
    public void testOrder() {
        Order<String> order = new Order<>(1, "20210511", "123");
        System.out.println(order.getOrderT());
        System.out.println(order);
    }

    @Test
    public void test2() {
        Order<String> order = new Order<>();
        Integer[] list = new Integer[]{1, 2, 3, 4, 5, 6};
        List<Integer> arrayList = order.copyArrayToList(list);
        System.out.println(arrayList);
    }

    /**
     * 通配符: ?
     */
    @Test
    public void test3() {
        List<String> list1 = new ArrayList<>();
        list1.add("username");
        list1.add("age");
        print(list1);

        List<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(2);
        print(list2);
    }

    private void print(List<?> list) {
        for (Object i : list) {
            System.out.println(i);
        }
    }
}
