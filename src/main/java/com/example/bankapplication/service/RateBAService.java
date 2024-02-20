package com.example.bankapplication.service;

import com.example.bankapplication.entity.RateBA;
import com.example.bankapplication.repository.RateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RateBAService {

    private final RateRepository rateRepository;

    public RateBA getRateBA(Long id){
        return rateRepository.getRateBAById(id);
    }

    public List<RateBA> getAllRateBA(){
        return rateRepository.findAll();
    }


    public void createRateBA(RateBA rateBA){
        rateRepository.save(rateBA);
    }

    public RateBA updateRateBA(Long id, Double percent){
        RateBA rateBA = rateRepository.findById(id).orElseThrow();
        rateBA.setPercentService(percent);
        rateRepository.save(rateBA);
        return rateRepository.getRateBAById(id);
    }
    public void deleteRateBA(Long id){
        rateRepository.deleteById(id);
    }

}
