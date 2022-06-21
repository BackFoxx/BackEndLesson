package com.example.demo.inheritance.entity_superclass;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@AttributeOverride(name = "id", column = @Column(name = "MEMBER_ID"))
// 부모에게 상속받은 id 속성의 컬럼명을 재정의,
// 둘 이상을 재정의하려면 @AttributeOverrides
public class Member extends BaseEntity {
    private String email;
}
