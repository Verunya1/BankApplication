package com.VeraRchik.bankapplication.dto;

import com.VeraRchik.bankapplication.enums.TypeTransaction;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionDto {

    private LocalDate dateTransaction;

    private TypeTransaction typeTransaction;

    private Double sum;
}
