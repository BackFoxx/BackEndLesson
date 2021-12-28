package jpapractice.com.jpapractice.MVC;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:appConfig.xml"})
@Transactional
@WebAppConfiguration
public class MemberServiceTest {

    @Test
    public void join() {
        System.out.println("안녕");
    }

    @Test
    public void findMembers() {
    }

    @Test
    public void findOne() {
    }
}