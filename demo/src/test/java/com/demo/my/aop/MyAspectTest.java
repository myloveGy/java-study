package com.demo.my.aop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class MyAspectTest {

    @Autowired
    private TargetInterface targetInterface;

    @Test
    public void test() {
        targetInterface.save();
    }

    @Test
    public void run() {
        targetInterface.run();
    }
}