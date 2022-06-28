package com.example.demo.쿼리언어.entity;

import javax.persistence.*;

@NamedEntityGraph(name = "Order.withAll",
attributeNodes = {
        @NamedAttributeNode(value = "member", subgraph = "team"),
},
subgraphs = @NamedSubgraph(name = "team", attributeNodes = @NamedAttributeNode("team"))
)
@Entity
public class Orders {
    @Id @GeneratedValue
    @Column(name = "ORDER_ID")
    private Long id;

    private int orderAmount;

    @Embedded
    private Address address;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member member;
}
