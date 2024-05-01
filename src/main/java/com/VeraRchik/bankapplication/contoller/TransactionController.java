package com.VeraRchik.bankapplication.contoller;

import com.VeraRchik.bankapplication.dto.TransactionDto;
import com.VeraRchik.bankapplication.entity.Transaction;
import com.VeraRchik.bankapplication.service.facade.ProductFacade;
import com.VeraRchik.bankapplication.service.facade.TransactionFacade;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/vBank")
public class TransactionController {


    private final TransactionFacade transactionFacade;
    private final ProductFacade productFacade;

    @GetMapping("/getTransaction")
    public ResponseEntity<TransactionDto> getTransaction(@RequestParam("id") Long id) {
        TransactionDto transactionDto = transactionFacade.getTransaction(id);
        return ResponseEntity.ok(transactionDto);
    }

    @GetMapping("/getTransactionAll")
    public ResponseEntity<List<TransactionDto>> getTransactionAll() {
        List<TransactionDto> transactionDtoList = transactionFacade.getTransactionAll();
        return ResponseEntity.ok(transactionDtoList);
    }

    @PostMapping("/createTransaction")
    public ResponseEntity<Void> createTransaction(@RequestBody Transaction transaction) {
        if(productFacade.changedMoney(transaction.getProduct().getNumberScore(),transaction)) {
            transactionFacade.createTransaction(transaction);
        }
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
