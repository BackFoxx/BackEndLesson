package com.example.demo.프록시;

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

//        printUserAndTeam(em, member);
//        printUser(em, member);
        justFindMember(em, member);
    }

    private static void justFindMember(EntityManager em, Member member) {
        Member findMember = em.getReference(Member.class, member.getId());
        Team findTeam = findMember.getTeam();

        System.out.println("findTeam.getName() = " + findTeam.getName());
    }

    private static void printUser(EntityManager em, Member member) {
        Member findMember = em.find(Member.class, member.getId());
        System.out.println("회원 이름 : " + findMember.getUsername());
    }

    private static void printUserAndTeam(EntityManager em, Member member) {
        Member findMember = em.find(Member.class, member.getId());
        Team findTeam = findMember.getTeam();

        System.out.println("findMember = " + findMember.getUsername());
        System.out.println("findTeam = " + findTeam.getName());
    }
}
