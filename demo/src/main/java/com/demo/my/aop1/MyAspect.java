package com.demo.my.aop1;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component("aopAspect")
@Aspect
public class MyAspect {

    @Before("execution(* com.demo.my.aop1.*.*(..))")
    public void before() {
        System.out.println("AOP1 = 前置: start");
    }

    @After("execution(* com.demo.my.aop1.*.*(..))")
    public void after() {
        System.out.println("AOP1 = 后置: end");
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
