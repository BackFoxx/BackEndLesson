import guestbook.config.ApplicationConfig;
import guestbook.dao.GuestBookDao;
import guestbook.dto.GuestBook;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class GuestBookDaoTest {
    @Test
    public void insert테스트() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        GuestBookDao dao = ac.getBean(GuestBookDao.class);

        GuestBook guestBook = new GuestBook();

    }
}
