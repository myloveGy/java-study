package thread;

public class Communication implements Runnable {
    private int ticket = 1;

    @Override
    public void run() {
        while (true) {
            if (handle()) {
                break;
            }
        }

        System.out.println("处理完成");
    }

    public synchronized boolean handle() {
        notifyAll();

        if (ticket > 100) {
            return true;
        }

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + " -- Ticket: " + ticket);
        ticket++;

        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return false;
    }

    public static void main(String[] args) {
        Communication myComm = new Communication();

        Thread t1 = new Thread(myComm);
        t1.setName("一");

        Thread t2 = new Thread(myComm);
        t2.setName("二");

        t1.start();
        t2.start();

        System.out.println("处理结束");
    }
}
