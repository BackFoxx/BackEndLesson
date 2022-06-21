package com.example.demo.inheritance.entity_table_per_class;

import javax.persistence.Entity;

@Entity
public class Movie extends Item {
    private String director;
    private String actor;
}
