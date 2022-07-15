package 디자인패턴;

public class 팩터리메서드패턴 {

    public static void main(String[] args) {
        Animal dog = new Dog();
        Animal cat = new Cat();

        AnimalToy dogToy = dog.getToy();
        AnimalToy catToy = cat.getToy();

        dogToy.identity();
        catToy.identity();
    }

    static abstract class Animal {
        abstract AnimalToy getToy();
    }

    static abstract class AnimalToy {
        abstract void identity();
    }

    static class Dog extends Animal {
        @Override
        AnimalToy getToy() {
            return new DogToy();
        }
        /* 오버라이드된 메서드가 객체를 반환한다. */
    }

    static class DogToy extends AnimalToy {
        @Override
        void identity() {
            System.out.println("나는 강아지 장난감");
        }
    }

    static class Cat extends Animal {
        @Override
        AnimalToy getToy() {
            return new CatToy();
        }
    }

    static class CatToy extends AnimalToy {
        @Override
        void identity() {
            System.out.println("나는 고양이 장난감");
        }
    }
}
