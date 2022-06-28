package com.example.jpaproject.repository;

import com.example.jpaproject.domain.OrderSearch;
import com.example.jpaproject.entity.Order;

import java.util.List;

public interface CustomOrderRepository {
    public List<Order> search(OrderSearch orderSearch);
}
