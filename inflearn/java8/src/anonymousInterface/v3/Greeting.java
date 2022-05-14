package anonymousInterface.v3;

public class Greeting {
    private String name;

    public Greeting(String name) {
        this.name = name;
    }

    public Greeting() {
    }

    public String hello(String name) {
        return "hello " + name;
    }

    public static String h1(String name) {
        return "hi " + name;
    }

    public String getName() {
        return name;
    }
}
