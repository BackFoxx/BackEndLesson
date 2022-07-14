package 자바의객체지향.interface1;

public class Speaker implements Speakable {
    @Override
    public void sayYes() {
        System.out.println("I say NO!!");
    }
}
