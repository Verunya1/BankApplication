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
        return transactionRepository.findById(id).orElseThrow();
    }

    public List<Transaction> getAllTransaction() {
        return transactionRepository.findAll(Sort.by(Sort.Direction.DESC, "dateTransaction"));
    }

    public List<Transaction> getTransactionsByUserId(Long userID) {
        return transactionRepository.findTransactionsByUserId(userID);
    }

    public void createTransaction(Transaction transaction) {
        transactionRepository.save(transaction);
    }
}
