package 디자인패턴;

/* 클라이언트가 전략을 생성해 컨텍스트에 주입하여 전략을 실행하는 패턴 */
public class 전략패턴 {

    public static void main(String[] args) {
        Strategy strategy = null;
        Soldier soldier = new Soldier();

        strategy = new StrategyGun();
        soldier.runContext(strategy);

        strategy = new StrategySword();
        soldier.runContext(strategy);

        strategy = new StrategyBow();
        soldier.runContext(strategy);
    }

    /* 컨텍스트 */
    static class Soldier {

        void runContext(Strategy strategy) {
            System.out.println("전투 시작");
            strategy.runStrategy();
            System.out.println("전투 종료");
        }
    }
    /* 전략 */
    interface Strategy {
        void runStrategy();
    }

    static class StrategyGun implements Strategy {
        @Override
        public void runStrategy() {
            System.out.println("탕 타당, 타다당");
        }
    }

    static class StrategySword implements Strategy {
        @Override
        public void runStrategy() {
            System.out.println("챙,, 챙챙");
        }
    }

    static class StrategyBow implements Strategy {
        @Override
        public void runStrategy() {
            System.out.println("숭.. 쐐액.. 쉑.. 최종 병기");
        }
    }

}
