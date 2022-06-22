package com.example.demo.임베디드타입;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Embeddable
public class Address {
    private String city;
    private String street;
    @Embedded
    private Zipcode zipcode;
}
