package com.example.demo.domainV2;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter @Setter
@Entity
public class OrderV2 {
    @Id
    @GeneratedValue
    @Column(name = "ORDER_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private MemberV2 member;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private ProductV2 product;

    private int orderAmount;
}
