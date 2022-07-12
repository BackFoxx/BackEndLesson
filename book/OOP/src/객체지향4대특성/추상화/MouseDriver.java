package 객체지향4대특성.추상화;

public class MouseDriver {
    public static void main(String[] args) {
        Mouse mickey = new Mouse();
        mickey.name = "미키";
        System.out.println("mickey = " + mickey);

        mickey.sing();

        Mouse jerry = new Mouse();
        jerry.name = "제리";
        jerry.age = 73;

        jerry.sing();
    }
}
