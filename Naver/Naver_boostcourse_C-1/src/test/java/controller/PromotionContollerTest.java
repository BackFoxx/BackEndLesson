package controller;

import config.ApplicationConfig;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.HashMap;

import static org.junit.Assert.*;

public class PromotionContollerTest {

    @Test
    public void PromotionControllerTest() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        PromotionContoller contoller = ac.getBean(PromotionContoller.class);
        HashMap<String, Object> promotionList = contoller.getPromotionList();
        System.out.println(promotionList);
    }


}