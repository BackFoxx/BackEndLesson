package 객체지향4대특성.추상화;

public class Mouse {
    public String name;
    public int age;
    public static int countOfTail = 1;

    public void sing() {
        System.out.println(this.name + " 찍찍!!");
    }
}
