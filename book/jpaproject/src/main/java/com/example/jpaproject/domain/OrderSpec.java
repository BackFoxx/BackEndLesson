package com.example.jpaproject.domain;

import com.example.jpaproject.entity.Member;
import com.example.jpaproject.entity.Order;
import com.example.jpaproject.entity.OrderStatus;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.*;

public class OrderSpec {
    public static Specification<Order> memberNameLike(final String memberName) {
        return (root, query, builder) -> {
            if (StringUtils.hasText(memberName)) return null;

            Join<Object, Member> m = root.join("member", JoinType.INNER);
            return builder.like(m.<String>get("name"), "%" + memberName + "%");
        };
    }

    public static Specification<Order> orderStatusEq(final OrderStatus orderStatus) {
        return (root, query, builder) -> {
            if (orderStatus == null) return null;

            return builder.equal(root.get("status"), orderStatus);
        };
    }
}
