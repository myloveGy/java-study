package com.demo.my.aop;

import org.aspectj.lang.ProceedingJoinPoint;

public class MyAspect {

    public void before() {
        System.out.println("前置: start");
    }

    public void after() {
        System.out.println("后置: end");
    }

    /**
     *
     * @param pjp 正在执行的连接点 === 切点
     */
    public Object around(ProceedingJoinPoint pjp) throws Throwable {

        System.out.println("开始执行: start");
        Object returnObject= pjp.proceed();
        // 切点方法
        System.out.println("结束执行：end");

        return returnObject;
    }
}
