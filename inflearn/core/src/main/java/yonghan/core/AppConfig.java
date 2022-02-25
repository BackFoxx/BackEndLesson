package yonghan.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import yonghan.core.discount.DiscountPolicy;
import yonghan.core.discount.FixDiscountPolicy;
import yonghan.core.discount.RateDiscountPolicy;
import yonghan.core.member.MemberRepository;
import yonghan.core.member.MemberService;
import yonghan.core.member.MemberServiceImpl;
import yonghan.core.member.MemoryMemberRepository;
import yonghan.core.order.OrderService;
import yonghan.core.order.OrderServiceImpl;

//@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(MemberRepository());
    }

    @Bean
    public MemberRepository MemberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(MemberRepository(), discountPolicy());
//        return null;
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new FixDiscountPolicy();
    }
}
