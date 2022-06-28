package com.example.demo.쿼리언어;

import com.example.demo.쿼리언어.entity.Member;
import com.example.demo.쿼리언어.entity.Orders;
import com.example.demo.쿼리언어.entity.Team;

import javax.persistence.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainJPQL {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("demo");
        EntityManager em = factory.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        saveMember(em);
        logic(em);

        tx.commit();
        em.close();
        factory.close();
    }

    private static void saveMember(EntityManager em) {
        em.setFlushMode(FlushModeType.COMMIT);

        Member member = new Member();
        member.setUsername("멤버");
        member.setAge(10);
        em.persist(member);

        em.flush();

        member.setAge(30);
    }

    private static void logic(EntityManager em) {
        /* TypeQuery, Query */
//        TypedQuery<Member> typeQuery = em.createQuery("select m from Member m", Member.class);
//        List<Member> typeResultList = typeQuery.getResultList();
//        for (Member findMember : typeResultList) {
//            System.out.println("member = " + findMember.getUsername());
//        }
//
//        Query query = em.createQuery("select m.username, m.age from Member m");
//        List resultList = query.getResultList();
//        for (Object o : resultList) {
//            Object[] result = (Object[]) o;
//            System.out.println("username = " + result[0]);
//            System.out.println("age = " + result[1]);
//        }

        /* 파라미터 바인딩 */
//        String usernameParam = "User1";
//        TypedQuery<Member> query
//                = em.createQuery("select m from Member m where m.username = :username",
//                Member.class);
//
//        query.setParameter("username", usernameParam);
//        List<Member> resultList = query.getResultList();

        /* 여러 값 조회 */
//        Query query = em.createQuery("select m.username, m.age from Member m");
//        List resultList = query.getResultList();
//
//        Iterator iterator = resultList.iterator();
//        while (iterator.hasNext()) {
//            Object[] row = (Object[]) iterator.next();
//            String username = (String) row[0];
//            Integer age = (Integer) row[1];
//        }

        /* DTO를 사용하여 조회된 값 저장 - 수동 매핑 */
//        List<Object[]> resultList = em.createQuery("select m.username, m.age from Member m")
//                .getResultList();
//
//        List<UserDto> userDtos = new ArrayList<>();
//        for (Object[] row : resultList) {
//            UserDto userDto = new UserDto();
//            userDto.setUsername((String) row[0]);
//            userDto.setAge((int) row[1]);
//            userDtos.add(userDto);
//        }
//        for (UserDto userDto : userDtos) {
//            System.out.println("userDto = " + userDto);
//        }

        /* TypeQuery를 사용해 Dto 저장 */
//        TypedQuery<UserDto> query = em.createQuery("select new com.example.demo.쿼리언어.dto.UserDto(m.username, m.age) from Member m", UserDto.class);
//        List<UserDto> resultList = query.getResultList();
//        for (UserDto userDto : resultList) {
//            System.out.println("userDto = " + userDto);
//        }

        /* 페이징 API */
//        TypedQuery<Member> query
//                = em.createQuery("select m from Member m order by m.id desc", Member.class);
//
//        query.setFirstResult(10); // 조회 시작 위치(0부터 시작)
//        query.setMaxResults(5); // 조회할 데이터 수
//        List<Member> resultList = query.getResultList();
//        for (Member member : resultList) {
//            System.out.println("member = " + member);
//        }

        /* JPQL 조인 */
//        String teamName = "팀!";
//        List<Member> resultList = em.createQuery("select m from Member m inner join m.team t " +
//                        "where t.name = :teamName", Member.class)
//                .setParameter("teamName", teamName)
//                .getResultList();
//
//        for (Member member : resultList) {
//            System.out.println("member = " + member);
//        }

        /* Named Query */
        Member findMember = em.createQuery("select m from Member m where m.age = 10", Member.class)
                .getSingleResult();
        System.out.println("findMember.getId() = " + findMember.getId());
        System.out.println("findMember.getUsername() = " + findMember.getUsername());
        System.out.println("findMember.getAge() = " + findMember.getAge());

        /* 엔티티 그래프 */
//        EntityGraph graph = em.getEntityGraph("Member.withOrder");
//        Map hints = new HashMap<>();
//        hints.put("javax.persistence.fetchgraph", graph);
//
//        em.find(Member.class, 1L, hints);

        /* 동적 엔티티 그래프 */
        EntityGraph<Orders> graph = em.createEntityGraph(Orders.class);
        graph.addAttributeNodes("member");

        Subgraph<Team> team = graph.addSubgraph("team");
        team.addAttributeNodes("team");

        Map hints = new HashMap();
        hints.put("javax.persistence.fetchgraph", graph);

        Orders orders = em.find(Orders.class, 1L, hints);
    }
}
