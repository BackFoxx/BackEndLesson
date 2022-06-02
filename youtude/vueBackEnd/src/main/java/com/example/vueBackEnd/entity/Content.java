package com.example.vueBackEnd.entity;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Calendar;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Content {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int contentId;



    private int user_id;
    private String title;
    private String context;

    @CreationTimestamp
    private Calendar createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    private Calendar updatedAt;
}
