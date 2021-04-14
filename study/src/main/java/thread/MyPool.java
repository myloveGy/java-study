package thread;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;

public class MyPool implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " i = " + i);
        }
    }
}

class MyPoolTest {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(10);
        service.execute(new MyPool());
        service.shutdown();
    }
}
