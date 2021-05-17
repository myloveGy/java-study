package com.demo.my.aop1;

import com.demo.my.config.SpringConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringConfiguration.class})
public class MyAspectTest {

    @Resource
    private TargetInterface target;

    @Test
    public void test() {
        target.save();
    }
}