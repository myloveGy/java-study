package thread;

import org.junit.Test;

public class MyThreadTest {
    @Test
    public void runTest() {
        MyThread t1 = new MyThread("窗口一");
        t1.start();

        MyThread t2 = new MyThread("窗口二");
        t2.start();
    }
}