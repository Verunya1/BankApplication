package com.VeraRchik.bankapplication.mapper;

import com.VeraRchik.bankapplication.dto.ProductDto;
import com.VeraRchik.bankapplication.entity.Product;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface ProductMapperInterface {

    ProductDto mapToProductDtoResponse(Product product);
}
