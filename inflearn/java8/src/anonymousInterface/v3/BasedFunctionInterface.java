package anonymousInterface.v3;

import java.util.function.*;

public class BasedFunctionInterface {
    public static void main(String[] args) {
        Function<Integer, Integer> plus10 = integer -> integer + 10;
        Function<Integer, Integer> multiply2 = (i) -> i * 2;

        Function<Integer, Integer> multiply2AndPlus10 = plus10.compose(multiply2);
        Function<Integer, Integer> plus10Andmulti2 = plus10.andThen(multiply2);

        Consumer<Integer> printT = (i) -> System.out.println(i);

        Supplier<Integer> get10 = () -> 10;

        Predicate<String> startsWithKeesun = (s) -> s.startsWith("keesun");

        UnaryOperator<Integer> plus20 = (i) -> i + 20;

        BiFunction<Integer, Integer, String> returnSumAsString = ((integer, integer2) -> String.valueOf(integer + integer2));
    }
}
