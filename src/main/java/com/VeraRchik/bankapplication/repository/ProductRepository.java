package com.VeraRchik.bankapplication.repository;

import com.VeraRchik.bankapplication.entity.Product;
import com.VeraRchik.bankapplication.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    List<Product> findProductsByUserId(Long userId);
}
