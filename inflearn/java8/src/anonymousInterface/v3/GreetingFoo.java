package anonymousInterface.v3;

public interface GreetingFoo {
    void printName();

    /*
    * @implSpec λλ¬Έμν
    * */
    default void printNameUpper() {
        System.out.println(getName().toUpperCase());
    }

    String getName();

    static void printAnythig() {
        System.out.println("hi");
    }
}
