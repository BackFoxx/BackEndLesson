package anonymousInterface.v3;

import java.util.function.Consumer;
import java.util.function.IntConsumer;

public class Lambda {
    public static void main(String[] args) {
        Lambda lambda = new Lambda();
        lambda.run();
    }

    private void run() {
        int baseNumber = 10;

        // 로컬 클래스
        class LocalClass {
            void printBaseNumber() {
                int baseNumber = 11;
                System.out.println(baseNumber); // 11 -> 쉐도잉 o
            }
        }

        // 익명 클래스
        Consumer<Integer> integerConsumer = new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                int baseNumber = 11;
                System.out.println(baseNumber); // 쉐도잉 o
            }
        };

        // 람다
        IntConsumer printInt = (i) -> System.out.println(i + baseNumber);

        printInt.accept(10);
    }
}
