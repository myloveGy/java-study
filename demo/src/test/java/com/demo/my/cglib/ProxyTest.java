package com.demo.my.cglib;

import com.demo.my.jdk.Advice;
import org.junit.Test;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class ProxyTest {

    @Test
    public void test() {
        // 目标对象
        final Target target = new Target();

        // 增强退休
        final Advice advice = new Advice();

        // 返回值 就是动态生成的代理对象 基于 cglib

        // 1. 创建增强器
        Enhancer enhancer = new Enhancer();

        // 2. 设置父类(目标)
        enhancer.setSuperclass(Target.class);

        // 3. 设置回调
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                advice.before();
                Object returnObject = method.invoke(target, objects); // 执行目标方法
                advice.afterReturning();
                return returnObject;
            }
        });

        // 4. 创建代理对象
        Target proxy = (Target) enhancer.create();

        proxy.save();
    }

}