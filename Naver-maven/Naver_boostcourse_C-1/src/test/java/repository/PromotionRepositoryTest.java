package repository;

import config.ApplicationConfig;
import dto.Promotion;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class PromotionRepositoryTest {

    @Test
    public void 프로모션목록구하기() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        PromotionRepository repository = ac.getBean(PromotionRepository.class);
        List<Map<String, Object>> promotionList = repository.getPromotionList();
        for (Map<String, Object> map : promotionList) {
            System.out.println(map);
        }
    }

}