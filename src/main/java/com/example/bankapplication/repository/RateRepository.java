package com.example.bankapplication.repository;


import com.example.bankapplication.entity.RateBA;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RateRepository extends JpaRepository<RateBA,Long> {
    RateBA getRateBAById(Long rateId);

}