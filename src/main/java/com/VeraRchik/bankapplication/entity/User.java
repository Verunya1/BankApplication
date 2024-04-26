package com.VeraRchik.bankapplication.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String role;

    private String firstName;

    private String lastName;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private Product product;
}
