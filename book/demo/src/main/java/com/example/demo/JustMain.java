package com.example.demo;

import com.example.demo.domain.Member;
import lombok.extern.slf4j.Slf4j;

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

        tx.begin();
        logic(em);
        tx.commit();

        em.close();
        factory.close();
    }

    private static void logic(EntityManager em) {
        new Member()
    }
}
