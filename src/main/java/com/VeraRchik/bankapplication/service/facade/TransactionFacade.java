package com.VeraRchik.bankapplication.service.facade;

import com.VeraRchik.bankapplication.dto.TransactionDto;
import com.VeraRchik.bankapplication.entity.Transaction;
import com.VeraRchik.bankapplication.mapper.TransactionMapperInterface;
import com.VeraRchik.bankapplication.service.TransactionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class TransactionFacade {

    private final TransactionService transactionService;

    private final TransactionMapperInterface transactionMapper;

    public TransactionDto getTransaction(Long id){
        log.info("Сущность с id={},{}", id, transactionService.getTransaction(id));
        return transactionMapper.mapToTransactionDtoResponse(transactionService.getTransaction(id));
    }
    public List<TransactionDto> getTransactionAll(){
        log.info("Получение всех сущностей {}", transactionService.getAllTransaction());
        List<Transaction> productList = transactionService.getAllTransaction();
        return productList.stream()
                .map(transactionMapper::mapToTransactionDtoResponse)
                .toList();
    }
    public void createTransaction(Transaction transaction){
        log.info("Создана сущность {}", transaction );
        transaction.setDateTransaction(LocalDate.now());
        transactionService.createTransaction(transaction);
    }
}
