package com.VeraRchik.bankapplication.contoller;

import com.VeraRchik.bankapplication.dto.TransactionDto;
import com.VeraRchik.bankapplication.dto.TransactionRequest;
import com.VeraRchik.bankapplication.entity.Transaction;
import com.VeraRchik.bankapplication.service.facade.ProductFacade;
import com.VeraRchik.bankapplication.service.facade.TransactionFacade;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/vBank")
@CrossOrigin(origins = "http://localhost:3000")
@PreAuthorize("hasAnyAuthority('USER', 'ADMIN')") //todo сделать в принципе авторизованный пользователь мог видеть транзакции и создавать их
public class TransactionController {


    private final TransactionFacade transactionFacade;
    private final ProductFacade productFacade;

    @GetMapping("/getTransaction/{id}")
    public ResponseEntity<TransactionDto> getTransaction(@PathVariable("id") Long id) {
        TransactionDto transactionDto = transactionFacade.getTransaction(id);
        return ResponseEntity.ok(transactionDto);
    }

    @GetMapping("/getTransactionAll")
    public ResponseEntity<List<TransactionDto>> getTransactionAll() {
        List<TransactionDto> transactionDtoList = transactionFacade.getTransactionAll();
        return ResponseEntity.ok(transactionDtoList);
    }

    @GetMapping("/getTransactionsUsers/{id}")
    public ResponseEntity<List<TransactionDto>> getTransactionsByUser(@PathVariable("id")  @NonNull Long id) {
        List<TransactionDto> transactionDtoList = transactionFacade.getTransactionsByUserId(id);
        return ResponseEntity.ok(transactionDtoList);
    }

//    @PostMapping("/createTransaction")
//    public ResponseEntity<Void> createTransaction(@RequestBody TransactionRequest transactionRequest){
//        if(productFacade.changedMoney(transactionRequest.getTransaction().getProduct().getNumberScore(),transactionRequest.getTransaction())) {
//            transactionFacade.createTransaction(transactionRequest.getTransaction(), transactionRequest.getUserId());
////            transactionRequest.getTransaction().getUser().getId()
//        }
//        return ResponseEntity.status(HttpStatus.CREATED).build();
//    }

    @PostMapping("/createTransaction")
    public ResponseEntity<Void> createTransaction(@RequestBody Transaction transaction){
        if(productFacade.changedMoney(transaction.getProduct().getNumberScore(),transaction)) {
            transactionFacade.createTransaction(transaction, transaction.getUser().getId());
//            transactionRequest.getTransaction().getUser().getId()
        }
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
