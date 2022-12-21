package hello.proxyagain;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Proxy;

@Slf4j
public class ProxyTest {
	@Test
	void DynamicA() {
		AInterface target = new AImpl();
		TimeInvocationHandler handler = new TimeInvocationHandler(target);
		AInterface proxy = (AInterface)Proxy.newProxyInstance(AInterface.class.getClassLoader(),
			new Class[] {AInterface.class}, handler);

		proxy.call();
		log.info("targetClass={}", target.getClass());
		log.info("proxyClass={}", proxy.getClass());
	}
}
