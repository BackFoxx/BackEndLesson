package com.example.demo;

import com.example.demo.inheritance.비식별복합키_EmbeddedId.ParentId;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JustMain {
    public static void main(String[] args) {
//        EntityManagerFactory factory = Persistence.createEntityManagerFactory("demo");
//        EntityManager em = factory.createEntityManager();
//        EntityTransaction tx = em.getTransaction();
//
//        tx.begin();

//        Parent parent = new Parent();
//        ParentId parentId = new ParentId("myId1", "myId2");
//        parent.setId(parentId);
//        parent.setName("안ㄴ녕");
//        em.persist(parent);
//
//        em.flush();
//        em.clear();
//
//        Parent findParent = em.find(Parent.class, parentId);
//        System.out.println("findParent.getName() = " + findParent.getName());

        ParentId parentId = new ParentId("1", "2");
        ParentId parentId2 = new ParentId("1", "2");

        System.out.println(parentId.equals(parentId2));

//        // 회원 저장
//        ProductV2 productA = new ProductV2();
//        productA.setId("productA");
//        productA.setName("상품A");
//        em.persist(productA);
//
//        // 상품 저장
//        MemberV2 memberA = new MemberV2();
//        memberA.setId("member1");
//        memberA.setUsername("회원1");
//        em.persist(memberA);
//
//        // 주문 저장
//        OrderV2 order = new OrderV2();
//        order.setMember(memberA);
//        order.setProduct(productA);
//        order.setOrderAmount(3);
//        em.persist(order);
//
//        // 조회
//        OrderV2 findOrder = em.find(OrderV2.class, 1L);
//        MemberV2 findMember = findOrder.getMember();
//        ProductV2 findProduct = findOrder.getProduct();
//
//        System.out.println("findProduct.getName() = " + findProduct.getName());
//        System.out.println("findMember = " + findMember.getUsername());
//        System.out.println("findOrder = " + findOrder.getOrderAmount());

//        tx.commit();
//        em.close();
    }
}
