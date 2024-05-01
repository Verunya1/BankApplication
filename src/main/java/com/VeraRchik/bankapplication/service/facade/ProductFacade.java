package com.VeraRchik.bankapplication.service.facade;

import com.VeraRchik.bankapplication.dto.ProductDto;
import com.VeraRchik.bankapplication.entity.Product;
import com.VeraRchik.bankapplication.entity.Transaction;
import com.VeraRchik.bankapplication.mapper.ProductMapperInterface;
import com.VeraRchik.bankapplication.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class ProductFacade {

    private final ProductService productService;

    private final ProductMapperInterface productMapper;

    public ProductDto getProduct(Long id){
        log.info("Сущность с id={},{}",id, productService.getProduct(id));
       return productMapper.mapToProductDtoResponse(productService.getProduct(id));
    }
    public List<ProductDto> getProductAll(){
        log.info("Получение всех сущностей {}", productService.getAllProduct());
        List<Product> productList = productService.getAllProduct();
        return productList.stream()
                .map(productMapper::mapToProductDtoResponse)
                .toList();
    }
    public void createProduct(Long rateId){
        productService.createProduct(rateId);
    }

    public void deleteProduct(Long id){
        log.info("Удален тариф {}", productService.getProduct(id));
        productService.deleteProduct(id);
    }
    public boolean changedMoney(Long productId, Transaction transaction){
        return productService.changedMoney(productId,transaction);
    }


}
