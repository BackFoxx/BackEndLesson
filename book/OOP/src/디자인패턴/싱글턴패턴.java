package 디자인패턴;

/* 클래스의 인스턴스, 즉 객체를 하나만 만들어 사용하는 패턴 */
public class 싱글턴패턴 {
    public static void main(String[] args) {
        Singleton instance1 = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        Singleton instance3 = Singleton.getInstance();

        System.out.println(instance1);
        System.out.println(instance2);
        System.out.println(instance3);
    }

    static class Singleton {
        static Singleton singletonObject; /* 1. 유일한 단일 객체를 참조할 정적 참조 변수 */

        private Singleton() {} /* 2. new를 통한 인스턴스 생성을 차단 */

        public static Singleton getInstance() {
            if (singletonObject == null) {
                singletonObject = new Singleton();
            }
            return singletonObject;
        } /* 유일한 단일 객체를 반환하는 정적 메서드 */
    }

}
