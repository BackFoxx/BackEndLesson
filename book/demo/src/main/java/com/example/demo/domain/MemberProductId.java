package com.example.demo.domain;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
// 복합 키를 위한 식별자 클래스
@Getter @Setter
public class MemberProductId implements Serializable {
    private String member;
    private String product;

    //hashcode and equals

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
