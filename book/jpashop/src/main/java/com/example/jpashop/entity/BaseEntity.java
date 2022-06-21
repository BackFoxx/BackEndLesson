package com.example.jpashop.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.MappedSuperclass;
import java.util.Date;

@Getter @Setter
@MappedSuperclass
public class BaseEntity {
    private Date createdDate;
    private Date lastModifiedDate;
}
