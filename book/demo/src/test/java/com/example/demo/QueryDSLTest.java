package com.example.demo;

import com.example.demo.쿼리언어.entity.Member;
import com.example.demo.쿼리언어.entity.Orders;
import com.example.demo.쿼리언어.entity.QMember;
import com.example.demo.쿼리언어.entity.QOrders;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

import static com.example.demo.쿼리언어.entity.QMember.member;
import static com.example.demo.쿼리언어.entity.QOrders.orders;
import static org.assertj.core.api.Assertions.*;

public class QueryDSLTest {

    EntityManagerFactory factory = Persistence.createEntityManagerFactory("demo");
    EntityManager em = null;
    EntityTransaction tx = null;

    @BeforeEach
    void setup() {
        em = factory.createEntityManager();
        tx = em.getTransaction();
        tx.begin();
    }

    @AfterEach
    void after() {
        tx.commit();
        em.close();
    }

    @Test
    void 시작() {
        Member m = new Member();
        m.setUsername("회원1");
        m.setAge(20);
        em.persist(m);

        Member m2 = new Member();
        m2.setUsername("회원1");
        m2.setAge(30);
        em.persist(m2);

        JPAQueryFactory query = new JPAQueryFactory(em);

        List<Member> members = query.select(member)
                .from(member)
                .where(member.username.eq("회원1")
                        .and(member.age.loe(10))
                        .or(member.username.contains("뭄무")))
                .orderBy(member.username.asc())
                .fetch();

        List<Orders> ordersList = query.selectFrom(orders)
                .join(orders.member, member)
                .fetch();


        assertThat(members).hasSize(2);
    }
}
