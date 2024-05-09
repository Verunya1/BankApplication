package com.VeraRchik.bankapplication.mapper;

import com.VeraRchik.bankapplication.dto.TransactionDto;
import com.VeraRchik.bankapplication.entity.Transaction;
import org.springframework.stereotype.Component;

@Component
public class TransactionMapper implements TransactionMapperInterface{

    @Override
    public TransactionDto mapToTransactionDtoResponse(Transaction transaction) {
        if (transaction == null) {
            return null;
        }

        TransactionDto transactionDto = new TransactionDto();
        transactionDto.setSum(transaction.getSum());
        transactionDto.setDateTransaction(transaction.getDateTransaction());
        transactionDto.setTypeTransaction(transaction.getTypeTransaction());
        transactionDto.setNameTransaction(transaction.getNameTransaction());
        transactionDto.setNumberScore(transaction.getProduct().getNumberScore());
        return transactionDto;
    }
}
