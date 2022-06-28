package com.example.jpaproject.repository;

import com.example.jpaproject.entity.item.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface ItemRepository
        extends JpaRepository<Item, Long>, QuerydslPredicateExecutor<Item> {
}
