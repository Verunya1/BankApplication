package com.VeraRchik.bankapplication.mapper;

import com.VeraRchik.bankapplication.dto.TransactionDto;
import com.VeraRchik.bankapplication.entity.Transaction;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TransactionMapperInterface {

    TransactionDto mapToTransactionDtoResponse(Transaction transaction);
}
