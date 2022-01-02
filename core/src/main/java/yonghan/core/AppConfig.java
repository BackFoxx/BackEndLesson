package yonghan.core;

import yonghan.core.discount.DiscountPolicy;
import yonghan.core.discount.FixDiscountPolicy;
import yonghan.core.discount.RateDiscountPolicy;
import yonghan.core.member.MemberRepository;
import yonghan.core.member.MemberService;
import yonghan.core.member.MemberServiceImpl;
import yonghan.core.member.MemoryMemberRepository;
import yonghan.core.order.OrderService;
import yonghan.core.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(MemberRepository());
    }

    private MemberRepository MemberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService() {
        return new OrderServiceImpl(MemberRepository(), discountPolicy());
    }

    public DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
