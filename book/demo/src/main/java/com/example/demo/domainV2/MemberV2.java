package com.example.demo.domainV2;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter
@NoArgsConstructor
@Entity
public class MemberV2 {
    @Id
    @Column(name = "MEMBER_ID")
    private String id;
    private String username;

    @OneToMany(mappedBy = "member")
    private List<OrderV2> orders = new ArrayList<>();

    public MemberV2(String id, String username) {
        this.id = id;
        this.username = username;
    }
}
