package service;

import config.ApplicationConfig;
import dto.Category;
import dto.Product;
import dto.Promotion;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Map;

@SpringBootTest
public class ServiceImplTest {

    @Test
    public void CategoryServiceTest() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        CategoryService service = ac.getBean(CategoryService.class);
        List<Map<String, Object>> list = service.selectAllCategories();
        for (Map map : list) {
            System.out.println(map);
        }
    }

    @Test
    public void ProductServiceTest() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        ProductService service = ac.getBean(ProductService.class);
        List<Map<String, Object>> productList = service.getProductsList(3, 0);
        System.out.println("productList = " + productList);
        System.out.println(service.totalCount(3));
    }

    @Test
    public void PromotionServiceTest() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        PromotionService service = ac.getBean(PromotionService.class);
        List<Map<String, Object>> list = service.getPromotionList();
        for (Map map : list) {
            System.out.println(map);
        }

    }
}
