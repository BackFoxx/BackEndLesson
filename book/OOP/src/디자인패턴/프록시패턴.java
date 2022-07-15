package 디자인패턴;

/* 제어 흐름을 조정하기 위한 목적으로 중간에 대리자를 두는 패턴 */
/* 호출한 타켓 메서드의 결과에 영향을 준다면 -> 데코레이더 패턴 */
public class 프록시패턴 {
    public static void main(String[] args) {
        IService service = new Proxy();
        System.out.println(service.runSomething());
    }

    static interface IService {
        String runSomething();
    }

    static class Service implements IService {
        public String runSomething() {
            return "run Something";
        }
    }

    static class Proxy implements IService {
        IService service;

        @Override
        public String runSomething() {
            System.out.println("호출에 대한 제어가 목적, 호출 결과를 그대로 반환");

            service = new Service();
            return service.runSomething();
        }
    }

}
