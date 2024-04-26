package com.VeraRchik.bankapplication.service;

import com.VeraRchik.bankapplication.entity.Product;
import com.VeraRchik.bankapplication.entity.RateBA;
import com.VeraRchik.bankapplication.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private ProductRepository productRepository;

    public Product getProduct(Long id){
//        return productRepository.(id);
    }
    /**
     * Получает список всех сущностей RateBA
     *
     * @return Список всех сущностей RateBA
     */
    public List<Product> getAllProduct(){
        return productRepository.findAll();
    }

//    /**
//     * Создает новую сущность RateBA
//     *
//     * @param rateBA Новая сущность RateBA для создания
//     */
    public void createProduct(Product product){
        productRepository.save(product);
    }

    /**
     * Обновляет процент у сущности RateBA по её id
     *
     * @param id Идентификатор сущности RateBA
     * @param percent Новое значение процента
     * @return Обновленная сущность RateBA
     */
//    public RateBA updateRateBA(Long id, Double percent){
//        RateBA rateBA = rateRepository.findById(id).orElseThrow();
//        rateBA.setPercentService(percent);
//        rateRepository.save(rateBA);
//        return rateRepository.getRateBAById(id);
//    }
    /**
     * Удаляет сущность RateBA по её id
     *
     * @param id Идентификатор сущности RateBA для удаления
     */
    public void deleteProduct(Long id){
        productRepository.deleteById(id);
    }

    // TODO сделать поиск по айди, сделать транзакции + на счет - на счет, если выводить последние транзакции, то надо создать бд транзакций и отсортировать
}
