package com.VeraRchik.bankapplication.repository;

import com.VeraRchik.bankapplication.entity.Transaction;
import com.VeraRchik.bankapplication.entity.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findTransactionsByUserId(Long userId);
}
