package repository;

import config.ApplicationConfig;
import dto.*;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

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
        List<Comments> comments = repository.getComments(1);
        for (Comments c : comments) {
            System.out.println(c.toString());
        }
    }

    @Test
    public void 상품전시정보구하기_DisplayInfo() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        ProductRepository repository = ac.getBean(ProductRepository.class);
        DisplayInfo displayInfo = repository.getDisplayInfo(1);
        System.out.println(displayInfo);
    }

    @Test
    public void 상품전시정보구하기_DisplayInfoImage() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        ProductRepository repository = ac.getBean(ProductRepository.class);
        DisplayInfoImage displayInfoImage = repository.getDisplayInfoImage(1);
        System.out.println(displayInfoImage);
    }

    @Test
    public void 상품전시정보구하기_ProductImages() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        ProductRepository repository = ac.getBean(ProductRepository.class);
        List<ProductImages> productImages = repository.getProductImages(1);
        for (ProductImages p : productImages) {
            System.out.println(p);
        }
    }

    @Test
    public void 상품전시정보구하기_ProductPrices() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        ProductRepository repository = ac.getBean(ProductRepository.class);
        List<ProductPrices> productPrices = repository.getProductPrices(1);
        for (ProductPrices p :
                productPrices) {
            System.out.println("p = " + p);
        }
    }

}