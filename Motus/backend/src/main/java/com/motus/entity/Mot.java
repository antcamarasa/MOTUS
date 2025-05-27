package com.motus.entity;
import lombok.Data;
import javax.persistence.*;
@Data
@Entity
public class Mot {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String word;
    private int longueur;
    private String difficulte;
}