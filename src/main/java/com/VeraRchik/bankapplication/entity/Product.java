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
@Table(name = "product") //карта
public class Product {  //счет
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numberScore;

    private String name; //платежная система
    private Double balance;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Transaction> transactions;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

}
