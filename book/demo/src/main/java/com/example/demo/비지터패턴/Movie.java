package com.example.demo.비지터패턴;

import com.example.demo.inheritance.entity_singletable.Item;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("M")
public class Movie extends Item {
    private String director;
    private String actor;
}
