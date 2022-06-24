package com.example.jpaproject.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Embeddable
@AllArgsConstructor
@Getter
public class Address {
    private String city;
    private String street;
    private String zipcode;

    protected Address() {
    }
}
