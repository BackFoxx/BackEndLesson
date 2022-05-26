package chapter1;

import net.sf.cglib.proxy.Enhancer;

public class Implement {
    public static void main(String[] args) {
        Chap_1_1 chap_1_1 = new Chap_1_1();

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(chap_1_1.getClass());
        enhancer.setCallback(new Proxy(chap_1_1));
        Chap_1_1 proxy = (Chap_1_1) enhancer.create();

        proxy.test("testArg");
    }
}

