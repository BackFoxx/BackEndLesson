package 객체지향4대특성.상속;

public class 박쥐 extends 포유류 implements 날수있는{
    public 박쥐() {
        super.myClass = "박쥐";
    }

    @Override
    public void fly() {
        System.out.println(this.myClass + " 나는 중!");
    }
}
