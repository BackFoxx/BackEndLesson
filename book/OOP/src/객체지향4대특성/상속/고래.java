package 객체지향4대특성.상속;

public class 고래 extends 포유류 implements 헤엄칠수있는{
    public 고래() {
        super.myClass = "고래";
    }

    @Override
    public void swim() {
        System.out.println(this.myClass + " 수영 중, 어푸어푸!");
    }
}
