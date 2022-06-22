package com.example.demo.영속성전이;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Setter @Getter
@Entity
public class Child {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Parent parent;
}
