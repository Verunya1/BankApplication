package com.VeraRchik.bankapplication.mapper;

import com.VeraRchik.bankapplication.dto.RateBADto;
import com.VeraRchik.bankapplication.entity.RateBA;
import org.springframework.stereotype.Component;

@Component
public class RateBAMapper implements RateBAMapperInterface  {
    public RateBADto rateToDto(RateBA rateBA) {
        if (rateBA == null) {
            return null;
        }

        RateBADto rateBADto = new RateBADto();
        rateBADto.setNameRate(rateBA.getNameRate());
        rateBADto.setDescription(rateBA.getDescription());
        rateBADto.setPercentService(rateBA.getPercentService());
        rateBADto.setNamePaymentSystem(rateBA.getNamePaymentSystem());

        return rateBADto;
    }
}
