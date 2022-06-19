package com.example.demo.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
//@Entity
@ToString
public class Member {
    @Id
    private String id;
    private String username;

    private Team team;
}
