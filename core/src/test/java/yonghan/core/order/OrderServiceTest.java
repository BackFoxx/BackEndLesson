package yonghan.core.order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import yonghan.core.member.Grade;
import yonghan.core.member.Member;
import yonghan.core.member.MemberService;
import yonghan.core.member.MemberServiceImpl;

public class OrderServiceTest {
    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();

    @Test
    void 주문() {
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "감자", 10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}
