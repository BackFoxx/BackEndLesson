package yonghan.core.order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import yonghan.core.discount.FixDiscountPolicy;
import yonghan.core.member.Grade;
import yonghan.core.member.Member;
import yonghan.core.member.MemoryMemberRepository;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceImplTest {

    @Test
    void createOrder() {
        MemoryMemberRepository memoryMemberRepository = new MemoryMemberRepository();
        memoryMemberRepository.save(new Member(1L, "member1", Grade.VIP));
        OrderServiceImpl orderService = new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
        Order order = orderService.createOrder(1L, "member1", 10000);
        Assertions.assertThat(order.getMemberId()).isEqualTo(1L);
    }

}