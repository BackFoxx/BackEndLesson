package anonymousInterface.v3;

import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class MethodReference {
    public static void main(String[] args) {
        UnaryOperator<String> h1 = Greeting::h1;
        System.out.println(h1.apply("keesun"));

        Greeting greeting = new Greeting();
        UnaryOperator<String> h2 = greeting::hello;
        System.out.println(h2.apply("keesun"));

        Supplier<Greeting> h3 = Greeting::new;
        Greeting greeting1 = h3.get();
        greeting1.getName();

        Function<String, Greeting> h4 = Greeting::new;
        Greeting keesun = h4.apply("keesun");
        System.out.println(keesun.getName());
    }
}
