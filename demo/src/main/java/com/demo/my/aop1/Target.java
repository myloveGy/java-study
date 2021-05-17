package com.demo.my.aop1;

import org.springframework.stereotype.Component;

@Component("target")
public class Target implements TargetInterface {
    @Override
    public void save() {
        System.out.println("AOP1 -> save: 开始跑了");
    }

    public void run() {
        System.out.println("AOP1 -> run: 开始跑了， 1、 2、 3...");
    }
}
