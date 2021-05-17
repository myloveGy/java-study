package features;

import org.junit.Test;

import java.util.Comparator;

public class LambdaTest {

    @Test
    public void test() {
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("我爱北京天安门");
            }
        };

        r1.run();
        System.out.println();
        Runnable r2 = () -> System.out.println("测试Lambda");
        r2.run();
    }

    @Test
    public void test1() {
        Comparator<Integer> comparable1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };

        System.out.println(comparable1.compare(1, 2));
        System.out.println();

        Comparator<Integer> comparator2 = (v1, v2) -> Integer.compare(v1, v2);
        System.out.println(comparator2.compare(1, 2));
    }
}
