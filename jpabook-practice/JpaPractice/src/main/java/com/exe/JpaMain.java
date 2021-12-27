package com.exe;

import com.entity.Member;
import com.entity.Order;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * Hello world!
 *
 */
public class JpaMain
{
    public static void main( String[] args )
    {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpabook");
        EntityManager manager = factory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();

        try {
            transaction.begin();
            logic(manager);
            transaction.commit();
            System.out.println("성공");
        } catch (Exception e) {
            transaction.rollback();
            System.out.println("실패");
        } finally {
          manager.close();
        }
        factory.close();
    }

    public static void logic(EntityManager entityManager) {

    }
}
