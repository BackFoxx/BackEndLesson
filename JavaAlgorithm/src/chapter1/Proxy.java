package chapter1;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.Arrays;

public class Proxy implements MethodInterceptor {
    private final Object target;

    public Proxy(Object target) {
        this.target = target;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("프록시 호출");
        Arrays.stream(args).forEach(System.out::println);
        return method.invoke(target, args);
    }
}
