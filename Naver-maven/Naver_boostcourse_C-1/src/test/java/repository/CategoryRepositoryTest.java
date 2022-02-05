package repository;

import config.ApplicationConfig;
import dto.Category;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

import static org.junit.Assert.*;

public class CategoryRepositoryTest {

    @Test
    public void 카테고리가져오기() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        CategoryRepository bean = ac.getBean(CategoryRepository.class);
        List<Category> categories = bean.selectAllCategories();
        System.out.println(categories);
    }

}