import org.junit.Test;

public class IntegerTest {

    @Test
    public void test1() {
        System.out.println("我的测试");
        Integer i = new Integer("123");
        System.out.println(i);
        System.out.println(i.equals(123));
        System.out.println(i.toString().equals("123"));
    }

}