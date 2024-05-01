package com.VeraRchik.bankapplication.mapper;

import com.VeraRchik.bankapplication.dto.ProductDto;
import com.VeraRchik.bankapplication.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface ProductMapperInterface {

    ProductDto mapToProductDtoResponse(Product product);
}
