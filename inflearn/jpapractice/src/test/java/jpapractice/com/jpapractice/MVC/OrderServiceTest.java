package jpapractice.com.jpapractice.MVC;

import jpapractice.com.jpapractice.Entity.*;
import jpapractice.com.jpapractice.Entity.item.Book;
import jpapractice.com.jpapractice.exception.NotEnoughStockException;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:appConfig.xml")
@Transactional
public class OrderServiceTest {

    @PersistenceContext
    EntityManager em;
    @Autowired
    OrderService orderService;
    @Autowired
    OrderRepository orderRepository;

    @Test
    public void 상품주문() throws Exception {
        //Given
        Member member = createMember();
        Item item = createBook("시골 JPA", 10000, 10);
        int orderCount = 2;
        //When
        Long orderId = orderService.order(member.getId(), item.getId(), orderCount);
        //Then
        Order getOrder = orderRepository.findOne(orderId);

        assertEquals(getOrder.getStatus(), OrderStatus.ORDER); // 주문시 상태는 ORDER
        assertEquals(1, getOrder.getOrderItems().size()); // 주문한 상품 종류 수
        assertEquals(10000*2, getOrder.getTotalPrice()); // 주문한 가격
        assertEquals(8, item.getStockQuantity()); // 남은 재고
    }

    @Test(expected = NotEnoughStockException.class)
    public void 상품주문_재고수량초과() throws Exception {
        //Given
        Member member = createMember();
        Item item = createBook("방구", 10000, 10);
        int orderCount = 11;

        //When
        orderService.order(member.getId(), item.getId(), orderCount);
        //Then
        fail("재고 수량 부족 예외가 발생하여야 한다");
    }

    @Test
    public void 주문취소() {
        //given
        Member member = createMember();
        Item item = createBook("북", 10000, 10);
        int orderCount = 2;
        Long orderId = orderService.order(member.getId(), item.getId(), orderCount);
        //when
        orderService.cancelOrder(orderId);

        //then
        Order getOrder = orderRepository.findOne(orderId);
        assertEquals(OrderStatus.ORDER, getOrder.getStatus()); //취소주문의 상태
        assertEquals(10, item.getStockQuantity()); // 취소된 상품의 재고
    }

    public Member createMember() {
        Member member = new Member();
        member.setName("회원1");
        member.setAddress(new Address("서울", "강가", "123-123"));
        em.persist(member);
        return member;
    }

    private Book createBook(String name, int price, int stockquantity) {
        Book book = new Book();
        book.setName(name);
        book.setStockQuantity(stockquantity);
        book.setPrice(price);
        em.persist(book);
        return book;
    }
}