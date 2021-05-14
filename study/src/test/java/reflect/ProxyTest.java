package reflect;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理
 */

interface Human {
    String getBelief();

    void eat(String food);
}

/**
 * 被代理类
 */
class SuperMain implements Human {

    @Override
    public String getBelief() {
        return "I believe I can fly!";
    }

    @Override
    public void eat(String food) {
        System.out.println("我喜欢吃: " + food);
    }
}

/**
 * 动态代理
 * 一、动态创建代理类
 * 二、动态调用被代理类的方法
 */

class ProxyFactory {
    public static Object getProxyInstance(Object object) {
        MyInvocationHandler handler = new MyInvocationHandler();
        handler.bind(object);
        return Proxy.newProxyInstance(object.getClass().getClassLoader(), object.getClass().getInterfaces(), handler);
    }
}

class MyInvocationHandler implements InvocationHandler {

    private Object object;

    public void bind(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(object, args);
    }
}

public class ProxyTest {

    @Test
    public void test() {
        Human proxyInstance = (Human) ProxyFactory.getProxyInstance(new SuperMain());

        System.out.println(proxyInstance.getBelief());
        proxyInstance.eat("四川麻辣烫");
    }
}
