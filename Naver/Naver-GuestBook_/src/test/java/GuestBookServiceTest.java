import guestbook.config.ApplicationConfig;
import guestbook.dto.GuestBook;
import guestbook.service.GuestBookService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Date;

public class GuestBookServiceTest {
    ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
    GuestBookService service = ac.getBean(GuestBookService.class);

    @Test
    public void 입력테스트() {
        GuestBook guestbook = new GuestBook();
        guestbook.setName("kang kyungmi22");
        guestbook.setContent("반갑습니다. 여러분. 여러분이 재미있게 공부하고 계셨음 정말 좋겠네요^^22");
        guestbook.setRegdate(new Date());
        GuestBook result = service.addGuestbook(guestbook, "127.0.0.1");
        System.out.println(result);
    }

}
