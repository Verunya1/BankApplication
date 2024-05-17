package com.VeraRchik.bankapplication.dto;

import com.VeraRchik.bankapplication.enums.TypeTransaction;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionDto {

    private LocalDateTime dateTransaction;

    private TypeTransaction typeTransaction;

    private Double sum;

    private String nameTransaction;

    private Long numberScore;

}
