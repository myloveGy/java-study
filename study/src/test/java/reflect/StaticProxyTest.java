package reflect;

import org.junit.Test;

interface InterFactor {
    void produce();
}

class ProxyFactor implements InterFactor {

    private final InterFactor factor;

    public ProxyFactor(InterFactor factor) {
        this.factor = factor;
    }

    @Override
    public void produce() {
        System.out.println("代理工厂前缀操作");
        factor.produce();
        System.out.println("代理工厂后置操作");
    }
}

class LiNiFactory implements InterFactor {
    @Override
    public void produce() {
        System.out.println("生成李宁的衣服");
    }
}

public class StaticProxyTest {

    @Test
    public void test() {
        LiNiFactory liNiFactory = new LiNiFactory();
        InterFactor interFactor = new ProxyFactor(liNiFactory);
        interFactor.produce();
    }
}
