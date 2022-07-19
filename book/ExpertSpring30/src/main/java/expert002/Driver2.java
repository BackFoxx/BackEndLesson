package expert002;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Driver2 {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("expert002/expert003.xml");
        Car car = context.getBean("car", Car.class);
        System.out.println(car.getTireBrand());
    }
}
