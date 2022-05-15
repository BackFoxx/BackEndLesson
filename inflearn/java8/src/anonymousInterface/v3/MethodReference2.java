package anonymousInterface.v3;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class MethodReference2 {
    public static void main(String[] args) {
//        List<String> names = new ArrayList<>();
//        names.add("A");
//        names.add("B");
//        names.add("C");

//        names.forEach(System.out::println);

//        Spliterator<String> spliterator = names.spliterator();
//        Spliterator<String> spliterator1 = spliterator.trySplit();
//        while (spliterator.tryAdvance(System.out::println));
//        System.out.println("=================");
//        while (spliterator1.tryAdvance(System.out::println));

//        Comparator<String> compareToIgnoreCase = String::compareToIgnoreCase;
//        names.sort(compareToIgnoreCase.reversed().thenComparing());


        List<Food> foods = new ArrayList<>();
        foods.add(new Food("Pizza", 200));
        foods.add(new Food("Bob", 100));
        foods.add(new Food("Chicken", 400));

        List<Food> result = foods.stream().map((food) -> {
            food.setName("changed");
            return food;
        }).collect(Collectors.toList());

        System.out.println(foods);
        foods.forEach(food -> System.out.println(food.getName()));

        System.out.println(result);
        result.forEach(food -> System.out.println(food.getName()));
    }
}
