package com.motus.entity;
import lombok.Data;
import javax.persistence.*;
@Data
@Entity
public class Score {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private int score;
    @ManyToOne
    private User user;
}