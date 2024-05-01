package com.VeraRchik.bankapplication.service;

import com.VeraRchik.bankapplication.entity.Transaction;
import com.VeraRchik.bankapplication.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.VeraRchik.bankapplication.enums.TypeTransaction.replenishment;
import static com.VeraRchik.bankapplication.enums.TypeTransaction.writeDowns;

@Service
@RequiredArgsConstructor
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;

    public Transaction getTransaction(Long id) {
        return transactionRepository.findById(id).orElseThrow();   //нужно ли ?
    }

    public List<Transaction> getAllTransaction() {
        return transactionRepository.findAll(Sort.by(Sort.Direction.DESC, "dateTransaction"));
    }

    public void createTransaction(Transaction transaction) {
        transactionRepository.save(transaction);
    }

    public void createTransactionWriteDowns(Transaction transaction) {
        transaction.setTypeTransaction(writeDowns);
        transactionRepository.save(transaction);
    }

    public void createTransactionReplenishment(Transaction transaction) {  //хз как отработает  мб можно просто создать
        transaction.setTypeTransaction(replenishment);
        transactionRepository.save(transaction);
    }
}
