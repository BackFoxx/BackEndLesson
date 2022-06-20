//package com.example.demo.domain;
//
//import lombok.*;
//
//import javax.persistence.*;
//import java.util.ArrayList;
//import java.util.List;
//
//@AllArgsConstructor
//@NoArgsConstructor
//@Getter @Setter
//@Entity
//@ToString
//public class Team {
//    @Id
//    @Column(name = "TEAM_ID")
//    private String id;
//    private String name;
//
//    @OneToMany(mappedBy = "team", fetch = FetchType.EAGER)
//    private List<Member> members = new ArrayList<>();
//
//    public Team(String id, String name) {
//        this.id = id;
//        this.name = name;
//    }
//
////    public void addMember(Member member) {
////        this.getMembers().add(member);
////        if (member.getTeam() != this) {
////            member.setTeam(this);
////        }
////    }
//}
