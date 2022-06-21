package com.example.demo.inheritance.비식별복합키_IdClass;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
public class ParentId implements Serializable {
    private String id1; // Parent.id1 매핑
    private String id2; // Parent.id2 매핑

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
