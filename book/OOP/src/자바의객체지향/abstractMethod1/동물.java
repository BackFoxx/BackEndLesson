package 자바의객체지향.abstractMethod1;

public abstract class 동물 {
    abstract void 울어보세요();

    static {
        System.out.println("동물 클래스 레디 온!");
    }
    /* 해당 패키지 또는 클래스가 처음으로 사용될 때에 static 영역에 로딩된다. */
}
