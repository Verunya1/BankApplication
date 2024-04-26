package com.VeraRchik.bankapplication.repository;

import com.VeraRchik.bankapplication.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
