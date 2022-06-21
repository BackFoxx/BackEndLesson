package com.example.demo.inheritance.식별복합키_EmbeddedId;

import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@EqualsAndHashCode
@Embeddable
public class GrandChildId implements Serializable {
    private ChildId childId;

    @Column(name = "GRANDCHILD_ID")
    private String id;
}
