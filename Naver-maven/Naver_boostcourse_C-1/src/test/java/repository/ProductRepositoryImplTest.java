package repository;

import config.ApplicationConfig;
import dto.Product;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Map;

public class ProductRepositoryImplTest {

    @Test
    public void 상품목록구하기() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        ProductRepository repository = ac.getBean(ProductRepository.class);
    }

    @Test
    public void 상품개수구하기() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        ProductRepository repository = ac.getBean(ProductRepository.class);
        int totalCount = repository.totalCount(2);
        Assertions.assertThat(totalCount).isEqualTo(10);
    }

}