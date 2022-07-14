package 자바의객체지향.interface1;

public interface Speakable {
    double PI = 3.14159;
    final double absoluteZeroPoint = -275.15;

    void sayYes();

    /* 인터페이스는 public 정적 상수와 public 추상 메서드만 가질 수 있다.
    * 따로 메서드에 public과 abstract, 필드에 static, final을 붙이지 않아도
    * 자바가 알아서 붙여준다. */
}
