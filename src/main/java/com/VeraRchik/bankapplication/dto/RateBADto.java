package com.VeraRchik.bankapplication.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RateBADto {

    private String nameRate;

    private String description;

    private Double percentService;
    private String namePaymentSystem;

}
