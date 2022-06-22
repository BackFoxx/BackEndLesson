package com.example.demo.영속성전이;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter
@Entity
public class Parent {
    @Id
    @GeneratedValue
    private Long id;

//    @OneToMany(mappedBy = "parent", cascade = CascadeType.PERSIST) // 영속성 전이
    @OneToMany(mappedBy = "parent", cascade = CascadeType.PERSIST, orphanRemoval = true) // 고아 객체 제거
    private List<Child> children = new ArrayList<>();
}
