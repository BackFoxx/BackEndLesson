package anonymousInterface.v8;

import net.sf.cglib.proxy.Enhancer;

public class Program {
    public static void main(String[] args) {
        NewLecExam newLecExam = new NewLecExam();
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(NewLecExam.class);
        enhancer.setCallback(new LogInterceptor(newLecExam));
        NewLecExam proxy = (NewLecExam) enhancer.create();
        System.out.println(proxy.test("bob", "momo"));
    }
}
