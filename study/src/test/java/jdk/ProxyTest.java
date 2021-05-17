package jdk;

import org.junit.Test;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest {

    @Test
    public void test() {

        Target target = new Target();

        Advice advice = new Advice();

        TargetInterface proxyTmp = (TargetInterface) Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                (Object proxy, Method method, Object[] args) -> {
                    advice.before();
                    Object returnObject = method.invoke(target, args);
                    advice.afterReturning();
                    return returnObject;
                }
        );

        proxyTmp.save();
    }
}
