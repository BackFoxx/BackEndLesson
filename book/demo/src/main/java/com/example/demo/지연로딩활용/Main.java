package com.example.demo.지연로딩활용;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("demo");
        EntityManager em = factory.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        logic(em);

        tx.commit();
        em.close();
        factory.close();
    }

    private static void logic(EntityManager em) {
        Member member = new Member();
        member.setId("member1");
        member.setUsername("회원");
        member.setAge(20);
        em.persist(member);

        em.flush();
        em.clear();

        Member findMember = em.find(Member.class, member.getId());
        List<Orders> orders = findMember.getOrders();
        System.out.println("orders.getClass().getName() = " + orders.getClass());
    }
}
