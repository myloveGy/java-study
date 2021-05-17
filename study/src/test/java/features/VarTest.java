package features;

import org.junit.Test;

import java.util.ArrayList;

public class VarTest {

    @Test
    public void test() {
        var num = 10;
        System.out.println(num);

        var list = new ArrayList<Integer>();
        list.add(10);
        list.add(20);
        list.add(30);

        for (Integer i: list) {
            System.out.println(i);
        }
    }

    @Test
    public void test1() {
        var s = "\n jinxing.liu \t";

        // 是否为空字符串
        System.out.println(s.isBlank());
        System.out.println("---" + s.strip() + "---");
        System.out.println("---" + s.trim() + "---");
    }
}
