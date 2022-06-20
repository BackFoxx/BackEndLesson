package com.example.demo.domainV2;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter @Setter
@Entity
public class ProductV2 {
    @Id @Column(name = "PRODUCT_ID")
    private String id;

    private String name;
}
