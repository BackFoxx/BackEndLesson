package 자바의객체지향.interface1;

public class Driver {
    public static void main(String[] args) {
        System.out.println(Speakable.absoluteZeroPoint);
        System.out.println(Speakable.PI);

        Speaker reporter1 = new Speaker();
        reporter1.sayYes();
    }
}
