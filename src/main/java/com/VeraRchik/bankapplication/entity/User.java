package com.VeraRchik.bankapplication.entity;

import com.VeraRchik.bankapplication.enums.Role;
import jakarta.persistence.*;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "app_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String login;
    private String password;
    private String phone;
    @Enumerated(EnumType.STRING)
    private Role role;

}