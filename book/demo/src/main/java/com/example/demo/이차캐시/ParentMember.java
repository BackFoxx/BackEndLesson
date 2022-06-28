package com.example.demo.이차캐시;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class ParentMember {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @OneToMany(mappedBy = "parentMember", cascade = CascadeType.ALL)
    private List<ChildMember> childMembers = new ArrayList<>();
}
