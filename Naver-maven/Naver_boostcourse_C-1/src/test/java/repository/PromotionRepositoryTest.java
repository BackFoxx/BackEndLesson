package repository;

import config.ApplicationConfig;
import dto.Promotion;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

import static org.junit.Assert.*;

public class PromotionRepositoryTest {

    @Test
    public void 프로모션리스트가져오기() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        PromotionRepository repository = ac.getBean(PromotionRepository.class);
        List<Promotion> promotionList = repository.getPromotionList();
        for (Promotion promotion : promotionList) {
            System.out.println(promotion.toString());
        }
    }

}