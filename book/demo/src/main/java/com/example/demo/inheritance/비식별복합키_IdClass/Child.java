package com.example.demo.inheritance.비식별복합키_IdClass;

import javax.persistence.*;

@Entity
public class Child {
    @Id
    private String id;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "PARENT_ID1",
                    referencedColumnName = "PARENT_ID1"),
            @JoinColumn(name = "PARENT_ID2",
                    referencedColumnName = "PARENT_ID2")
    }) // 참조 테이블이 복합키를 가지고 있을때 @JoinColumns로 여러 컬럼을 매핑한다.
    private Parent parent;
}
