package com.example.demo.inheritance.식별복합키_IdClass;

import lombok.EqualsAndHashCode;

import java.io.Serializable;

@EqualsAndHashCode
public class GrandChildId implements Serializable {
    private ChildId child;
    private String id;
}
