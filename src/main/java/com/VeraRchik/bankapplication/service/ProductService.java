package com.VeraRchik.bankapplication.service;

import com.VeraRchik.bankapplication.entity.Product;
import com.VeraRchik.bankapplication.entity.RateBA;
import com.VeraRchik.bankapplication.entity.Transaction;
import com.VeraRchik.bankapplication.entity.User;
import com.VeraRchik.bankapplication.enums.TypeTransaction;
import com.VeraRchik.bankapplication.repository.ProductRepository;
import com.VeraRchik.bankapplication.repository.RateRepository;
import com.VeraRchik.bankapplication.repository.TransactionRepository;
import com.VeraRchik.bankapplication.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductService {


    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private RateRepository rateRepository;

    @Autowired
    private UserRepository userRepository;

    public Product getProduct(Long id) {
        return productRepository.findById(id).orElseThrow();   //нужно ли ?
    }

    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    public List<Product> getProductByUserId(Long userID) {
        return productRepository.findProductsByUserId(userID);
    }

    public void createProduct(Long rateId, Long userId ) {
        Product product = new Product();
        product.setName(rateRepository.findById(rateId).orElseThrow().getNamePaymentSystem());
        product.setBalance(0.0);
        product.setTransactions(new ArrayList<>());
        var user = userRepository.findById(userId).orElseThrow();
        product.setUser(user);
        log.info("юзер=",user);
        log.info("карта=",user.getProducts());
        productRepository.save(product);
        log.info("Создана сущность {}", product);

    }

    public void deleteProduct(Long id) { // закрытие счета
        productRepository.deleteById(id);
    }

    @Transactional
    public boolean changedMoney(Long productId, Transaction transaction) {
        var balance = getProduct(productId);

        if (transaction.getSum() > balance.getBalance() && transaction.getTypeTransaction().equals(TypeTransaction.writeDowns)) {
            log.info("Недостаточно денег на счете {}", getProduct(productId).getBalance());
            return false;
        }
        if (transaction.getTypeTransaction().equals(TypeTransaction.writeDowns)) {
            balance.setBalance(balance.getBalance() - transaction.getSum());
            log.info("Баланс счета изменился и составляет {}", getProduct(productId).getBalance());
            return true;
        }
        balance.setBalance(balance.getBalance() + transaction.getSum());
        log.info("Баланс счета изменился и составляет {}", getProduct(productId).getBalance());
        return true;
    }

    // TODO сделать поиск по айди, сделать транзакции + на счет - на счет, если выводить последние транзакции, то надо создать бд транзакций и отсортировать
}
