package com.VeraRchik.bankapplication.mapper;

import com.VeraRchik.bankapplication.dto.ProductDto;
import com.VeraRchik.bankapplication.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper implements ProductMapperInterface {
    @Override
    public ProductDto mapToProductDtoResponse(Product product) {
        if (product == null) {
            return null;
        }

        ProductDto productDto = new ProductDto();
        productDto.setBalance(product.getBalance());
        productDto.setName(product.getName());
        productDto.setNumberScore(product.getNumberScore());
        return productDto;
    }
}
