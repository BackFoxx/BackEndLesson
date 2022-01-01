package yonghan.core;

import yonghan.core.member.Grade;
import yonghan.core.member.Member;
import yonghan.core.member.MemberService;
import yonghan.core.member.MemberServiceImpl;
import yonghan.core.order.Order;
import yonghan.core.order.OrderService;
import yonghan.core.order.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "감자", 10000);
        System.out.println("order = " + order);
        System.out.println("order.calculatePrice() = " + order.calculatePrice());
    }
}
