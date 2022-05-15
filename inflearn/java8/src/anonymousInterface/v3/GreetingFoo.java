package anonymousInterface.v3;

public interface GreetingFoo {
    void printName();

    /*
    * @implSpec 대문자화
    * */
    default void printNameUpper() {
        System.out.println(getName().toUpperCase());
    }

    String getName();

    static void printAnythig() {
        System.out.println("hi");
    }
}
