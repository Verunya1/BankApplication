package com.example.bankapplication.service;

import com.example.bankapplication.entity.RateBA;
import com.example.bankapplication.repository.RateRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RateBAServiceTest {

    @Mock
    private RateRepository rateRepository;

    @InjectMocks
    private RateBAService rateBAService;

    @Test
    void getRateBA() {
        RateBA expectedRateBA = new RateBA();
        expectedRateBA.setId(1L);
        expectedRateBA.setPercentService(0.05);

        when(rateRepository.getRateBAById(1L)).thenReturn(expectedRateBA);

        RateBA result = rateBAService.getRateBA(1L);

        assertEquals(expectedRateBA, result);
    }

    @Test
    void getAllRateBA() {
        List<RateBA> expectedRateBAList = new ArrayList<>();
        expectedRateBAList.add(new RateBA(1L, 0.05));
        expectedRateBAList.add(new RateBA(2L, 0.06));
        expectedRateBAList.add(new RateBA(3L, 0.07));

        when(rateRepository.findAll()).thenReturn(expectedRateBAList);

        List<RateBA> result = rateBAService.getAllRateBA();

        assertEquals(expectedRateBAList, result);
    }

    @Test
    void createRateBA() {
        RateBA rateBA = new RateBA(1L, 0.05);

        rateBAService.createRateBA(rateBA);

        verify(rateRepository, times(1)).save(rateBA);
    }

    @Test
    void updateRateBA() {

    }

    @Test
    void deleteRateBA() {
        Long idToDelete = 1L;

        rateBAService.deleteRateBA(idToDelete);

        verify(rateRepository, times(1)).deleteById(idToDelete);
    }
}