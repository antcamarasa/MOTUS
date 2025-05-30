package com.motus.entity;
import lombok.Data;
import javax.persistence.*;
@Data
@Entity
@Table(name="users")
public class User {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column(unique=true)
    private String pseudo;
    private String password;
}