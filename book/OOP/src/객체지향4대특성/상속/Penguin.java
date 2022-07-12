package 객체지향4대특성.상속;

public class Penguin extends Animal {
    public String habitat;

    public void showHabitat() {
        System.out.printf("%s는 %s에 살아.\n", super.name, this.habitat);
    }
}
