package repository;

import config.ApplicationConfig;
import dto.Comment;
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
        int totalCount = repository.getTotalCount(2);
        Assertions.assertThat(totalCount).isEqualTo(10);
    }

    @Test
    public void 평균점수구하기() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        ProductRepository repository = ac.getBean(ProductRepository.class);
        double averageScore = repository.getAverageScore(1);
        System.out.println("averageScore = " + averageScore);
    }

    @Test
    public void 상품전시정보구하기_Comment() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        ProductRepository repository = ac.getBean(ProductRepository.class);
        List<Comment> comment = repository.getComment(1);
        for (Comment c : comment) {
            System.out.println(c.toString());
        }
    }

}