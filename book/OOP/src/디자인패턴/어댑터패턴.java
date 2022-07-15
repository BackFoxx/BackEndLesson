package 디자인패턴;

/* 객체를 속성으로 만들어서 참조하는 디자인 패턴
* -> 호출당하는 쪽의 메서드를 호출하는 쪽의 코드에 대응하도록 중간에 변환기를 통해 호출하는 패턴 */
public class 어댑터패턴 {
    public static void main(String[] args) {
//        ServiceA sa1 = new ServiceA();
//        ServiceB sb1 = new ServiceB();
//
//        sa1.runServiceA();
//        sb1.runServiceB();

        AdapterServiceA asa1 = new AdapterServiceA();
        AdapterServiceB asb1 = new AdapterServiceB();

        asa1.runService();
        asb1.runService();
    }

    static class ServiceA {
        void runServiceA() {
            System.out.println("ServiceA");
        }
    }

    static class ServiceB {
        void runServiceB() {
            System.out.println("ServiceB");
        }
    }

    /* 어댑터 */
    static class AdapterServiceA {
        ServiceA sa1 = new ServiceA();

        void runService() {
            sa1.runServiceA();
        }
    }

    static class AdapterServiceB {
        ServiceB sb1 = new ServiceB();

        void runService() {
            sb1.runServiceB();
        }
    }

}
