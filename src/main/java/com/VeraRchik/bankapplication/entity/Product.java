package com.VeraRchik.bankapplication.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.math.BigInteger;

@Entity
@Getter
@Setter
//@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name="product")
public class Product {  //счет
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numberScore;

    private String name; //платежная система

//    private BigDecimal balance;
    private Double balance;

    /*private String numberScore;*/ // номер счета
}
