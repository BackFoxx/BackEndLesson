package anonymousInterface.v3;

public class DefaultFoo implements GreetingFoo {
    private String name;

    @Override
    public void printName() {
        System.out.println("foo");
    }

    @Override
    public void printNameUpper() {
        System.out.println(this.name.toUpperCase());
    }

    @Override
    public String getName() {
        return this.name;
    }
}
