package hello.proxy.pureProxy.concreteProxy;

import hello.proxy.pureProxy.concreteProxy.code.ConcreteClient;
import hello.proxy.pureProxy.concreteProxy.code.ConcreteLogic;
import hello.proxy.pureProxy.concreteProxy.code.TimeProxy;
import org.junit.jupiter.api.Test;

public class ConcreteProxyTest {
    @Test
    void noProxy() {
        ConcreteLogic concreteLogic = new ConcreteLogic();
        ConcreteClient client = new ConcreteClient(concreteLogic);
        client.execute();
    }

    @Test
    void proxy() {
        ConcreteLogic concreteLogic = new ConcreteLogic();
        ConcreteLogic timeProxy = new TimeProxy(concreteLogic);
        ConcreteClient client = new ConcreteClient(timeProxy);
        client.execute();
    }
}
