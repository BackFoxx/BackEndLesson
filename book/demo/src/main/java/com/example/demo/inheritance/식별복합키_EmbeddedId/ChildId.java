package com.example.demo.inheritance.식별복합키_EmbeddedId;

import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@EqualsAndHashCode
@Embeddable
public class ChildId implements Serializable {
    private String parentId;

    @Column(name = "CHILD_ID")
    private String id;
}
