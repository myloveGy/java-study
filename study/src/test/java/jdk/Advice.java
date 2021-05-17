package jdk;

public class Advice {
    public void before() {
        System.out.println("前置");
    }

    public void afterReturning() {
        System.out.println("后置");
    }
}
