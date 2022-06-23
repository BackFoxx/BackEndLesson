//package com.example.demo.영속성전이;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.EntityTransaction;
//import javax.persistence.Persistence;
//
//public class Main {
//    public static void main(String[] args) {
//        EntityManagerFactory factory = Persistence.createEntityManagerFactory("demo");
//        EntityManager em = factory.createEntityManager();
//        EntityTransaction tx = em.getTransaction();
//
//        tx.begin();
//
//        logic(em);
//
//        tx.commit();
//        em.close();
//        factory.close();
//    }
//
//    private static void logic(EntityManager em) {
////        영속성 전이 미사용
////        Parent parent = new Parent();
////        em.persist(parent);
////
////        Child child1 = new Child();
////        child1.setParent(parent);
////        parent.getChildren().add(child1);
////        em.persist(child1);
////
////        Child child2 = new Child();
////        child2.setParent(parent);
////        parent.getChildren().add(child2);
////        em.persist(child2);
//
////        CASCADE.persist
//        Child child1 = new Child();
//        Child child2 = new Child();
//
//        Parent parent = new Parent();
//        child1.setParent(parent); // 연관관계 추가
//        child2.setParent(parent); // 연관관계 추가
//        parent.getChildren().add(child1);
//        parent.getChildren().add(child2);
//
//        em.persist(parent);
//
//        parent.getChildren().remove(0);
//    }
//}
