package 디자인패턴;

/* 상위 클래스의 견본 메서드에서 하위 클래스가 오버라이딩한 메서드를 호출하는 패턴 */
public class 템플릿메서드패턴 {
    public static void main(String[] args) {
        Animal dog = new Dog();
        Animal cat = new Cat();

        dog.playWithOwner();
        System.out.println();
        cat.playWithOwner();
    }

    static abstract class Animal {
        public void playWithOwner() {
            System.out.println("짖어!");
            this.play(); /* 공통 로직을 수행하는 템플릿 메서드 */
            this.runSomething(); /* 선택적으로 오버라이딩할 수 있는 훅(Hook) 메서드 */
            System.out.println("잘했어.");
        }

        abstract void play();

        void runSomething() {
            System.out.println("꼬리 살랑 살랑");
        }
    }

    static class Dog extends Animal {
        @Override
        void play() {
            System.out.println("뭄무");
        }
    }

    static class Cat extends Animal {
        @Override
        void play() {
            System.out.println("냥냐");
        }
    }

}
