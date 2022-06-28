package com.example.demo;

import com.example.demo.inheritance.비식별복합키_EmbeddedId.ParentId;
import com.example.demo.쿼리언어.entity.Member;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.CacheMode;
import org.hibernate.ScrollMode;
import org.hibernate.ScrollableResults;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

@Slf4j
public class JustMain {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("demo");
        EntityManager em = factory.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        Session session = em.unwrap(Session.class);

        tx.begin();

        ScrollableResults scroll = session.createQuery("select m from Member m")
                .setCacheMode(CacheMode.IGNORE)
                .scroll(ScrollMode.FORWARD_ONLY);

        int count = 0;

        while (scroll.next()) {
            Member m = (Member) scroll.get(0);
            m.setAge(m.getAge() + 10);

            count++;

            if (count % 100 == 0) {
                session.flush();
                session.clear();
            }
        }

        tx.commit();
        em.close();
        factory.close();
    }
}
