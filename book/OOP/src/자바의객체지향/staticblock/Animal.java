package 자바의객체지향.staticblock;

public class Animal {
    static int age = 0;

    static {
        System.out.println("Animal class ready on!");
    }
}
