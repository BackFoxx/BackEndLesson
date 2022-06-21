package com.example.demo.inheritance.entity_join;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
// 상속 매핑은 매핑 전략을 정해야 한다
@DiscriminatorColumn(name = "DTYPE")
// 부모 클래스에 구분 컬럼을 지정한다.
// 이 컬럼으로 저장된 자식 테이블을 구분할 수 있다.
public abstract class Item {
    @Id
    @GeneratedValue
    @Column(name = "ITEM_ID")
    private Long id;

    private String name;
    private int price;
}
