package 디자인패턴;

/* 전략을 익명 클래스로 구현한 전략 패턴 */
public class 템플릿콜백패턴 {

    public static void main(String[] args) {
        Soldier soldier = new Soldier();
        soldier.runContext("응가 투척!");

        soldier.runContext("방구 뿡!");
    }

    interface Strategy {
        void runStrategy();
    }

    static class Soldier {
        void runContext(String weaponSound) {
            System.out.println("전투 시작");
            this.executeStrategy(weaponSound);
            System.out.println("전투 종료");
        }

        private void executeStrategy(String weaponSound) {
            Strategy strategy = () -> System.out.println(weaponSound);
            strategy.runStrategy();
        }
    }
}
