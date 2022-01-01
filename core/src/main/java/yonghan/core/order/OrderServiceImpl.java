package yonghan.core.order;

import yonghan.core.discount.DiscountPolicy;
import yonghan.core.discount.FixDiscountPolicy;
import yonghan.core.member.Member;
import yonghan.core.member.MemberRepository;
import yonghan.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
