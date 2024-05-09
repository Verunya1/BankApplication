package com.VeraRchik.bankapplication.entity;

import com.VeraRchik.bankapplication.enums.TypeTransaction;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "transaction")
@Getter
@Setter
//@ToString
@AllArgsConstructor
@NoArgsConstructor
//@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Transaction {
    @Id
//    @EqualsAndHashCode.Exclude
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nameTransaction;

    private LocalDate dateTransaction;

    @Enumerated(EnumType.STRING)
    private TypeTransaction typeTransaction;

    //    private BigDecimal sum;
    private Double sum;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "transaction_id")
    private Product product;
}
