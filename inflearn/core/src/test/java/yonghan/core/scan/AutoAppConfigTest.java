package yonghan.core.scan;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import yonghan.core.AutoAppConfig;
import yonghan.core.member.MemberRepository;
import yonghan.core.member.MemberService;
import yonghan.core.member.MemoryMemberRepository;
import yonghan.core.order.OrderServiceImpl;

import static org.assertj.core.api.Assertions.*;

public class AutoAppConfigTest {

    @Test
    void basicScan() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);

        OrderServiceImpl orderServiceImpl = ac.getBean("orderServiceImpl", OrderServiceImpl.class);

    }
}
