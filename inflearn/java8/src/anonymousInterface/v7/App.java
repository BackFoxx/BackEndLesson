package anonymousInterface.v7;

import java.util.Arrays;

@Chicken("양념")
@Chicken("후라이드")
public class App {
    public static void main(String[] args) {
//        Chicken[] arrays = App.class.getAnnotationsByType(Chicken.class);
//        Arrays.stream(arrays).forEach(System.out::println);

        ChickenContainer annotation = App.class.getAnnotation(ChickenContainer.class);
        Arrays.stream(annotation.value()).forEach(System.out::println);
    }

//    static class FeelsLikeChicken<@Chicken T> {
//        public static <@Chicken C> void print(C c) {
//            System.out.println(c);
//        }
//    }
}
