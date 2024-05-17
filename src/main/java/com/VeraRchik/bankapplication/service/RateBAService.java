package com.VeraRchik.bankapplication.service;

import com.VeraRchik.bankapplication.entity.RateBA;
import com.VeraRchik.bankapplication.repository.RateRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RateBAService {

    private final RateRepository rateRepository;

    /**
     * Получает сущность RateBA по её id
     *
     * @param id Идентификатор сущности RateBA.
     * @return Сущность RateBA, если найдена, или выбрасывает исключение, если сущность не найдена
     */
    public RateBA getRateBA(Long id){
//        return rateRepository.getRateBAById(id);
        return rateRepository.findById(id).orElseThrow();
    }
    /**
     * Получает список всех сущностей RateBA
     *
     * @return Список всех сущностей RateBA
     */
    public List<RateBA> getAllRateBA(){
        return rateRepository.findAll();
    }

    /**
     * Создает новую сущность RateBA
     *
     * @param rateBA Новая сущность RateBA для создания
     */
    @Transactional
    public void createRateBA(RateBA rateBA){
        rateRepository.save(rateBA);
    }

    /**
     * Обновляет процент у сущности RateBA по её id
     *
     * @param id Идентификатор сущности RateBA
     * @param percent Новое значение процента
     * @return Обновленная сущность RateBA
     */
    public RateBA updateRateBA(Long id, Double percent){
        RateBA rateBA = rateRepository.findById(id).orElseThrow();
        rateBA.setPercentService(percent);
        rateRepository.save(rateBA);
        return rateBA;
//        return rateRepository.getRateBAById();
    }
    /**
     * Удаляет сущность RateBA по её id
     *
     * @param id Идентификатор сущности RateBA для удаления
     */
    public void deleteRateBA(Long id){
        rateRepository.deleteById(id);
    }

}
