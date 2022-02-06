package repository;

import config.ApplicationConfig;
import dto.Product;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class ProductRepositoryImplTest {

    @Test
    public void 상품목록구하기() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        ProductRepository repository = ac.getBean(ProductRepository.class);
        List<Product> productsList = repository.getProductsList(2, 0);
        System.out.println("productsList = " + productsList);
    }

}