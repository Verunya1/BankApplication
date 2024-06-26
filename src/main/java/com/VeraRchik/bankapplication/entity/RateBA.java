package com.VeraRchik.bankapplication.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "broker_account_rate")
public class RateBA {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nameRate;

    private String description;

    private Double percentService;

    private String namePaymentSystem;

    public RateBA(Long id, Double percent) {
        this.id = id;
        this.percentService = percent;
    }
}
