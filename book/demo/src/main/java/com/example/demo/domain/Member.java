package com.example.demo.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter
@NoArgsConstructor
@Entity
public class Member {
    @Id
    @Column(name = "MEMBER_ID")
    private String id;
    private String username;

    @OneToMany(mappedBy = "member")
    private List<MemberProduct> memberProducts;

//    @ManyToMany
//    @JoinTable(name = "MEMBER_PRODUCT",
//            joinColumns = @JoinColumn(name = "MEMBER_ID"),
//            inverseJoinColumns = @JoinColumn(name = "PRODUCT_ID"))
//    private List<Product> products = new ArrayList<>();

//    public void addProduct(Product product) {
//        this.getProducts().add(product);
//        product.getMembers().add(this);
//    }

//    @OneToOne
//    @JoinColumn(name = "LOCKER_ID")
//    private Locker locker;

//    @ManyToOne
//    @JoinColumn(name = "TEAM_ID")
//    private Team team;

    public Member(String id, String username) {
        this.id = id;
        this.username = username;
    }

//    public void setTeam(Team team) {
//        if (this.team != null) {
//            this.team.getMembers().remove(this);
//        }
//        this.team = team;
//        if (!team.getMembers().contains(this)) {
//            team.getMembers().add(this);
//        }
//    }
}
