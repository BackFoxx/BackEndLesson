package anonymousInterface.v1;

@FunctionalInterface
public interface RunSomething {
    void doIt();

    public static void printName() {
        System.out.println("Keesun");
    }

    default void printAge() {
        System.out.println("38?");
    }
}

/*
"추상 메서드"가 1개여야 함수형 인터페이스
다른 형태의 메서드는 상관없음
* */