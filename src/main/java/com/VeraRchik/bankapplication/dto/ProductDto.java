package com.VeraRchik.bankapplication.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

    private String name; //платежная система

    private Double balance;

    private Long numberScore; // номер счета
}
