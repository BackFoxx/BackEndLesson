package com.example.demo.inheritance.비식별복합키_EmbeddedId;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
@Setter @Getter
@Entity
public class Parent {
    @EmbeddedId
    private ParentId id;

    private String name;
}
