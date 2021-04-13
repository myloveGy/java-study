package thread;

import java.util.concurrent.locks.ReentrantLock;

public class MyLock implements Runnable {

    private int ticket = 100;

    private final ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            try {
                lock.lock();
                if (ticket <= 0) {
                    break;
                }


                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread().getName() + " --- Ticket: " + ticket);
                ticket--;
            } finally {
                lock.unlock();
            }

        }
    }

    public static void main(String[] args) {
        MyLock lock = new MyLock();

        Thread t1 = new Thread(lock);
        t1.setName("Start1");
        Thread t2 = new Thread(lock);
        t2.setName("Start2");
        Thread t3 = new Thread(lock);
        t3.setName("Start3");

        t1.start();
        t2.start();
        t3.start();
    }
}
