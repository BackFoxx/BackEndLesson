package kr.or.connect;

import car.ApplicationConfig2;
import car.Car;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextExam04 {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig2.class);

        Car car = ac.getBean(Car.class);
        car.run();
    }
}
