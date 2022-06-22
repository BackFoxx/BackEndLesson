package com.example.demo.지연로딩;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

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
        Team team = new Team();
        team.setName("뭄무팀");
        em.persist(team);

        Member member = new Member();
        member.setUsername("뭄무");
        member.setTeam(team);
        em.persist(member);

        em.flush();
        em.clear();

        Member findMember = em.find(Member.class, member.getId());
        Team findTeam = findMember.getTeam(); // 객체 그래프 탐색
        System.out.println("findTeam.getClass() = " + findTeam.getClass());
        findTeam.getName(); // 팀 실제 객체 사용
    }
}
