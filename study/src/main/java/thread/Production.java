package thread;

class Product {

    private int number = 0;

    public synchronized void production() {
        if (number <= 0) {
            System.out.println(Thread.currentThread().getName() + " 生产: " + number + "号产品");
            number++;
            notify();
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void consumption() {
        if (number > 0) {
            System.out.println(Thread.currentThread().getName() + " 消费: " + number + "号产品");
            number--;
            notify();
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class Production extends Thread {

    private Product product;

    public Production(Product product) {
        this.product = product;
    }

    @Override
    public void run() {
        while (true) {
            this.product.production();
        }
    }
}

class Consumption extends Thread {

    private Product product;

    public Consumption(Product product) {
        this.product = product;
    }

    @Override
    public void run() {
        while (true) {
            this.product.consumption();
        }
    }
}

class ProductionTest {
    public static void main(String[] args) {
        Product product = new Product();

        Production p1 = new Production(product);
        p1.setName("生产者01");

        Consumption c1 = new Consumption(product);
        c1.setName("消费者01");

        p1.start();
        c1.start();
    }
}
