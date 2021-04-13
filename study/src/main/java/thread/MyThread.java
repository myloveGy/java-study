package thread;

public class MyThread extends Thread {

    /**
     * 票号：默认100张
     */
    public static int ticket = 100;

    private String name;

    private static Object object = new Object();

    public MyThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        while (ticket > 0) {
            synchronized (object) {
                if (ticket <= 0) {
                    continue;
                }

                try {
                    Thread.sleep(100);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                System.out.println(name + " --- Ticket: " + ticket);
                ticket--;
            }
        }
    }

    public static void main(String[] args) {

        MyThread t1 = new MyThread("窗口一");
        t1.setPriority(Thread.MIN_PRIORITY);
        t1.start();
        System.out.println("start: 1");

        MyThread t2 = new MyThread("窗口二");
        t2.setPriority(Thread.NORM_PRIORITY);
        t2.start();
        System.out.println("start: 2");

        MyThread t3 = new MyThread("窗口三");
        t3.setPriority(Thread.MAX_PRIORITY);
        t3.start();
        System.out.println("start: 3");
    }
}
