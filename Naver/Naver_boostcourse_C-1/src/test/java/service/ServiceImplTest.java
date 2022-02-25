package service;

import config.ApplicationConfig;
import dto.Category;
import dto.Product;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class ServiceImplTest {

    @Test
    public void CategoryServiceTest() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        CategoryService service = ac.getBean(CategoryService.class);
        HashMap<String, Object> categories = service.getCategories();
        Assertions.assertThat(categories).isNotNull();
    }

    @Test
    public void ProductServiceTest() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        ProductService service = ac.getBean(ProductService.class);
        HashMap<String, Object> products = service.getProducts(0, 3);
        System.out.println("products = " + products);
    }

    @Test
    public void PromotionServiceTest() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        PromotionService service = ac.getBean(PromotionService.class);
    }
}
