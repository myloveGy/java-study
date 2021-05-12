package collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class IteratorTest {

    @Test
    public void test() {
        Collection<String> collection = new ArrayList<>();
        collection.add("jinxing.liu");
        collection.add("hello world");

        // 迭代器
        Iterator<String> iterator = collection.iterator();
        while (iterator.hasNext()) {
            String name = iterator.next();
            if (name.equals("hello word")) {
                iterator.remove();
            }

            System.out.println(name);
        }

        // for 处理
        for (String name : collection) {
            System.out.println(name);
        }
    }

    @Test
    public void test1() {
        String[] strings = new String[]{"jinxing.liu", "hello world!"};
        for (String name : strings) {
            System.out.println(name);
        }
    }
}
