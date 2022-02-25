package controller;

import config.ApplicationConfig;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.HashMap;

import static org.junit.Assert.*;

public class ProductControllerTest {
    @Test
    public void 프로덕트컨트롤러() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        ProductController controller = ac.getBean(ProductController.class);
        HashMap<String, Object> displayInfo = controller.getDisplayInfo(1);
        System.out.println("displayInfo = " + displayInfo);
    }
}