package com.example.demo.비지터패턴;

import com.example.demo.inheritance.entity_singletable.Item;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("A")
// 구분 컬럼 DTYPE에 입력할 값을 지정한다.
public class Album extends Item {
    private String artist;
}
