package com.example.demo.inheritance.일대일식별관계;

import javax.persistence.*;

@Entity
public class BoardDetail {
    @Id
    private Long boardId;

    @MapsId // this.boardId에 Board 기본키가 매핑
    @OneToOne
    @JoinColumn(name = "BOARD_ID")
    private Board board;

    private String content;
}
