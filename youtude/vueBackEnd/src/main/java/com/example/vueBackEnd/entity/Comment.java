package com.example.vueBackEnd.entity;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Comment {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int CommentId;
    private int userId;
    private int contentId;

    private String context;

    @CreationTimestamp
    private Calendar createdAt;

    @UpdateTimestamp
    private Calendar updatedAt;
}
