package com.example.mythymeleaf2.repository;

import com.example.mythymeleaf2.model.QUser;
import com.example.mythymeleaf2.model.User;
import com.querydsl.jpa.impl.JPAQuery;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class CustomizedUserRepositoryImpl implements CustomizedUserRepository {
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<User> findByCustomUsername(String username) {
        QUser u = QUser.user;
        JPAQuery<?> query = new JPAQuery<>(em);
        return query.select(u)
                .from(u)
                .where(u.username.contains(username))
                .fetch();
    }
}
