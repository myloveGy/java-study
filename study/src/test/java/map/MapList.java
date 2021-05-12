package map;

import org.junit.Test;

import java.util.*;

public class MapList {
    @Test
    public void test() {
        Map<Object, Object> map = new HashMap<>();
        map.put(null, null);
        map.put("123", 456);
        System.out.println(map);
        map.remove(null);
        map.remove("123");
        System.out.println(map.size());
        System.out.println(map);
        map.put("123", 456);
        System.out.println(map.get("123"));
        System.out.println(map.containsKey("123"));
        System.out.println(map.containsValue(456));
    }

    @Test
    public void test1() {
        Map<Object, Object> map = new HashMap<>();
        map.put("username", "jinxing.liu");
        map.put("age", 28);
        map.put(45, 45);

        // 遍历Keys
        Set<Object> set = map.keySet();
        for (Object o : set) {
            System.out.println(o);
        }

        // 遍历values
        Collection<Object> collection = map.values();
        for (Object o : collection) {
            System.out.println(o);
        }

        // 遍历keys 和 values
        Set<Map.Entry<Object, Object>> items = map.entrySet();
        for (Map.Entry<Object, Object> item : items) {
            System.out.println(item.getKey() + " " + item.getValue());
        }
    }
}
