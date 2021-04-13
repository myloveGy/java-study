package thread;

public class MyRunnable implements Runnable {

    private int ticket = 100;

    @Override
    public void run() {
        while (show()) {
            //
        }
    }

    private synchronized boolean show() {
        if (ticket <= 0) {
            return false;
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + " Ticket: " + ticket);
        ticket--;
        return true;
    }

    public static void main(String[] args) {
        MyRunnable runnable = new MyRunnable();
        new Thread(runnable).start();
        new Thread(runnable).start();
        new Thread(runnable).start();
    }
}
