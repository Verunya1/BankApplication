package com.VeraRchik.bankapplication.mapper;

import com.VeraRchik.bankapplication.dto.TransactionDto;
import com.VeraRchik.bankapplication.entity.Transaction;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TransactionMapperInterface {

    TransactionDto mapToTransactionDtoResponse(Transaction transaction);
}
