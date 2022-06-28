package com.example.jpaproject.service;

import com.example.jpaproject.entity.Address;
import com.example.jpaproject.entity.Member;
import com.example.jpaproject.entity.Order;
import com.example.jpaproject.entity.OrderStatus;
import com.example.jpaproject.entity.item.Book;
import com.example.jpaproject.entity.item.Item;
import com.example.jpaproject.exception.NotEnoughStockException;
import com.example.jpaproject.repository.OrderRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@Transactional(readOnly = true)
class OrderServiceTest {
    @PersistenceContext
    EntityManager em;
    @Autowired
    OrderService orderService;
    @Autowired
    OrderRepository orderRepository;

    @Test
    void 상품주문() {
        // given
        Member member = createMember();
        Item item = createBook("시골 JPA", 10000, 10);
        int orderCount = 2;

        // when
        Long orderId = orderService.order(member.getId(), item.getId(), orderCount);

        // then
        Order findOrder = orderRepository.findById(orderId).get();

        assertThat(findOrder.getStatus()).isEqualTo(OrderStatus.ORDER);
        assertThat(findOrder.getOrderItems()).hasSize(1);
        assertThat(findOrder.getTotalPrice()).isEqualTo(10000 * 2);
        assertThat(item.getStockQuantity()).isEqualTo(8);
    }

    @Test
    void 상품주문_재고수량초과() {
        Member member = this.createMember();
        Item item = this.createBook("시골 JPA", 10000, 10);
        int orderCount = 11;

        assertThatThrownBy(() -> {
            this.orderService.order(member.getId(), item.getId(), orderCount);
        }).isInstanceOf(NotEnoughStockException.class);
    }

    @Test
    void 주문취소() {
        // given
        Member member = createMember();
        Item item = this.createBook("시골 JPA", 10000, 10);
        int orderCount = 2;

        Long orderId = this.orderService.order(member.getId(), item.getId(), orderCount);

        // when
        this.orderService.cancelOrder(orderId);

        // then
        Order findOrder = this.orderRepository.findById(orderId).get();

        assertThat(findOrder.getStatus()).isEqualTo(OrderStatus.CANCEL);
        assertThat(item.getStockQuantity()).isEqualTo(10);

    }

    private Book createBook(String name, int price, int stockQuantity) {
        Book book = new Book();
        book.setName(name);
        book.setPrice(price);
        book.setStockQuantity(stockQuantity);
        em.persist(book);
        return book;
    }

    private Member createMember() {
        Member member = new Member();
        member.setName("회원1");
        member.setAddress(new Address("서울", "강가", "123-123"));
        this.em.persist(member);
        return member;
    }
}