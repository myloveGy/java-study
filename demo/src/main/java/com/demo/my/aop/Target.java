package com.demo.my.aop;

public class Target implements TargetInterface {
    @Override
    public void save() {
        System.out.println("save running...");
    }

    public void run() {
        System.out.println("开始跑了， 1、 2、 3...");
    }
}
