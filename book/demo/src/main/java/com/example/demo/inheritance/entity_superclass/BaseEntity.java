package com.example.demo.inheritance.entity_superclass;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
// 공통으로 사용되는 매핑 정보만 제공하고, 테이블에는 매핑되지 않는 객체
public abstract class BaseEntity {
    @Id @GeneratedValue
    private Long id;
    private String name;
}
