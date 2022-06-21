package com.example.demo.inheritance.식별복합키_EmbeddedId;

import javax.persistence.*;

@Entity
public class Child {

    @EmbeddedId
    private ChildId id;

    @MapsId("parentId") // ChildId.parentId 매핑
    // 외래 키와 매핑한 연관관게룰 기본 키에도 매핑하겠다는 뜻
    @ManyToOne
    @JoinColumn(name = "PARENT_ID")
    public Parent parent;

    private String name;
}
