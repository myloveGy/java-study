import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class CompareTest {
    @Test
    public void test() {
        String[] arr = new String[]{"A", "b", "d", "c", "g", "myName"};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        assertEquals("c", arr[2]);

        Integer[] integers = new Integer[]{4, 1, 100, 2};
        Arrays.sort(integers);
        System.out.println(Arrays.toString(integers));
        assertEquals(new Integer(100), integers[3]);
    }

    @Test
    public void testGoods() {
        Goods[] goods = new Goods[]{
                new Goods("username1", 42),
                new Goods("username2", 42)
        };
        Arrays.sort(goods);
        System.out.println(Arrays.toString(goods));
    }
}
