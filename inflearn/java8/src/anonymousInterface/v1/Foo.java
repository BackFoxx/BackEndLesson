package anonymousInterface.v1;

public class Foo {
    public static void main(String[] args) {
        RunSomething runSomething = new RunSomething() {
            //익명 내부 클래스 anonymous inner class
            @Override
            public void doIt() {
                System.out.println("hello");
            }
        };

        //익명 내부 클래스 anonymous inner class
        RunSomething runSomethingWithLambda = () -> {
            System.out.println("hello");
            System.out.println("lambda");
        };

        runSomething.doIt();
        runSomethingWithLambda.doIt();
    }
}
