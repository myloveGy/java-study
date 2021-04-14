package thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class MyCallable implements Callable<Integer> {

    @Override
    public Integer call() {
        int sum = 0;
        for (int i = 0; i <= 100; i++) {
            sum += i;
            System.out.println(Thread.currentThread().getName() + " 当前 i = " + i);
        }

        return sum;
    }
}

class MyCallableTest {
    public static void main(String[] args) {

        MyCallable callable = new MyCallable();

        FutureTask<Integer> futureTask = new FutureTask<>(callable);

        Thread t1 = new Thread(futureTask);
        t1.setName("测试01");
        t1.start();

        Thread t2 = new Thread(futureTask);
        t2.setName("测试02");
        t2.start();

        try {
            Integer sum = futureTask.get();
            System.out.println("总和为:" + sum);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
