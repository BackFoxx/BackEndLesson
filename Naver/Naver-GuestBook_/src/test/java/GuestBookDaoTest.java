import guestbook.config.ApplicationConfig;
import guestbook.dao.GuestBookDao;
import guestbook.dao.LogDao;
import guestbook.dto.GuestBook;
import guestbook.dto.Log;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Date;

public class GuestBookDaoTest {
    @Test
    public void insert테스트() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        GuestBookDao dao = ac.getBean(GuestBookDao.class);

        GuestBook guestBook = new GuestBook();
        guestBook.setName("님이");
        guestBook.setContent("반갑습니다");
        guestBook.setRegdate(new Date());
        Long id = dao.insert(guestBook);
        System.out.println("id = " + id);
    }

    @Test
    public void 로그테스트() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        GuestBookDao dao = ac.getBean(GuestBookDao.class);

        LogDao logDao = ac.getBean(LogDao.class);
        Log log = new Log();
        log.setIp("127.0.0.1");
        log.setMethod("insert");
        log.setRegdate(new Date());
        logDao.insert(log);
    }
}
