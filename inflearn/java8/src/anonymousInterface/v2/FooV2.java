package anonymousInterface.v2;

public class FooV2 {
    public static void main(String[] args) {
        RunSomethingV2 runSomething = new RunSomethingV2() {
            @Override
            public int doIt(int number) {
                return number + 10;
            }
        };

        RunSomethingV2 runSomethingWithLambda = number -> number + 10;

        /* 함수라고 볼 수 없는 경우 */

        int baseNumber = 10;

        RunSomethingV2 runSomethingNot = number -> number + baseNumber;

        System.out.println(runSomethingWithLambda.doIt(10));
    }
}
