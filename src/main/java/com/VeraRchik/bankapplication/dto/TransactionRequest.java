package com.VeraRchik.bankapplication.dto;

import com.VeraRchik.bankapplication.entity.Transaction;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionRequest {
    @NonNull
    private Transaction transaction;
    @NonNull
    private Long userId;
}
