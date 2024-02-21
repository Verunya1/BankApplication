package com.VeraRchik.bankapplication.mapper;

import com.VeraRchik.bankapplication.dto.RateBADto;
import com.VeraRchik.bankapplication.entity.RateBA;
import org.mapstruct.Mapper;

@Mapper
public interface RateBAMapperInterface {
    RateBADto rateToDto(RateBA rateBA);
}
