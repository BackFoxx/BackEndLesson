package 자바의객체지향.this1;

public class Driver {
    public static void main(String[] args) {
        펭귄 뽀로로 = new 펭귄();
        뽀로로.test();

        펭귄.test(뽀로로);
    }
}
