package anonymousInterface.V5;

import anonymousInterface.Progress;
import anonymousInterface.v4.OnlineClass;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Optionall {
    public static void main(String[] args) {
        List<OnlineClass> springClasses = new ArrayList<>();
        springClasses.add(new OnlineClass(1, "spring boot", true));
        springClasses.add(new OnlineClass(2, "spring data jpa", true));
        springClasses.add(new OnlineClass(3, "spring mvc", false));
        springClasses.add(new OnlineClass(4, "spring core", false));
        springClasses.add(new OnlineClass(5, "rest api development", false));

        Optional<OnlineClass> spring = springClasses.stream()
                .filter(onlineClass -> onlineClass.getTitle().startsWith("asdd"))
                .findFirst();

//        spring.ifPresent(oc -> System.out.println(oc.getTitle()));
//        OnlineClass onlineClass = spring.orElse(Optionall::createNewJpaClass);
//        OnlineClass onlineClass = spring.orElseGet(Optionall::createNewJpaClass);
//        OnlineClass onlineClass = spring.orElseThrow(RuntimeException::new);

        Optional<Progress> progress = spring.flatMap(OnlineClass::getProgress);

    }

    private static OnlineClass createNewJpaClass() {
        System.out.println("creating new instance");
        return new OnlineClass(10, "momo", true);
    }
}
