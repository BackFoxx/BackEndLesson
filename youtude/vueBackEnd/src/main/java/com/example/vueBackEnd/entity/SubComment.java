package com.example.vueBackEnd.entity;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Calendar;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@Entity
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class SubComment {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int subcommentId;
    private int commentId;
    private int userId;
    private String context;

    @CreationTimestamp
    private Calendar createdAt;

    @UpdateTimestamp
    private Calendar updatedAt;
}
