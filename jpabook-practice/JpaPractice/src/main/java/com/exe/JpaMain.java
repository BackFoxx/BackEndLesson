package com.exe;

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
            System.out.println("안녕");
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
          manager.close();
        }
        factory.close();
    }
}
