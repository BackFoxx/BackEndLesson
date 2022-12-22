package hello.springbasic.member;

public interface DiscountPolicy {
    int discount(Member member, int price);
}
