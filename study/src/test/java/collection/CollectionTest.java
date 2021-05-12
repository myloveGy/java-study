package collection;

import demo.Season;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class CollectionTest {
    @Test
    public void test() {

        Collection<Object> collection = new ArrayList<>();

        collection.add(12);
        collection.add("username");
        collection.add("25");
        collection.add(Season.AUTUMN);

        // 获取集合大小
        System.out.println(collection.size());

        // 是否包含指定元素
        boolean contains = collection.contains("25");
        System.out.println(contains);

        System.out.println(collection.contains(Season.AUTUMN));
        System.out.println(collection.contains(Season.SPRING));

        // 判断是否全部包含
        Collection<Object> collection1 = Arrays.asList("25", 12);
        System.out.println(collection.containsAll(collection1));
    }

    @Test
    public void test1() {
        Collection<Object> collection = new ArrayList<>();
        collection.add(1);
        collection.add(123);
        collection.add(456);
        System.out.println(collection.size());
        // 删除指定元素
        System.out.println(collection.remove(456));
        System.out.println(collection.size());

        System.out.println(collection.removeAll(Arrays.asList(1, 456)));
        System.out.println(collection);
    }

    @Test
    public void test2() {
        List<String> list = Arrays.asList("123", "567", "456", "234");
        System.out.println(list);
        for (String name : list) {
            System.out.println(name);
        }
    }
}
