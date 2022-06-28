package com.example.jpaproject.domain;

import com.example.jpaproject.entity.Order;
import com.example.jpaproject.entity.OrderStatus;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.Specification;

import static com.example.jpaproject.domain.OrderSpec.memberNameLike;
import static com.example.jpaproject.domain.OrderSpec.orderStatusEq;

@Getter @Setter
public class OrderSearch {
    private String memberName;
    private OrderStatus orderStatus;

    public Specification<Order> toSpecification() {
        return Specification.where(memberNameLike(memberName))
                .and(orderStatusEq(orderStatus));
    }
}
