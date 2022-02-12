package service;

import config.ApplicationConfig;
import dto.Category;
import dto.Product;
import org.assertj.core.api.Assertions;
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
        List<Category> categories = service.selectAllCategories();
        Assertions.assertThat(categories).isNotNull();
    }

    @Test
    public void ProductServiceTest() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        ProductService service = ac.getBean(ProductService.class);
        List<Product> productsList = service.getProductsList(3, 0);
        for (Product product :
                productsList) {
            System.out.println("product = " + product.toString());
        }
    }

    @Test
    public void PromotionServiceTest() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        PromotionService service = ac.getBean(PromotionService.class);
    }
}
