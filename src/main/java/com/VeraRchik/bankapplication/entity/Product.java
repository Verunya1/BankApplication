package com.VeraRchik.bankapplication.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

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

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Transaction> transactions;
}
