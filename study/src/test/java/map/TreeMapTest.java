package map;

import org.junit.Test;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class TreeMapTest {

    @Test
    public void test() {
        TreeMap<Goods, Integer> map = new TreeMap<>();
        Goods g1 = new Goods("Tom", 12);
        Goods g2 = new Goods("Jerry", 23);
        Goods g3 = new Goods("Jack", 100);
        Goods g4 = new Goods("Rose", 32);
        map.put(g2, 102);
        map.put(g1, 101);
        map.put(g3, 103);
        map.put(g4, 104);
        System.out.println(map);

        Set<Map.Entry<Goods, Integer>> set = map.entrySet();
        for (Map.Entry<Goods, Integer> item : set) {
            System.out.println(item.getKey() + ":" + item.getValue());
        }
    }
}
