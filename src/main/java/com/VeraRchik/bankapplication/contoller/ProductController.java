package com.VeraRchik.bankapplication.contoller;

import com.VeraRchik.bankapplication.dto.ProductDto;
import com.VeraRchik.bankapplication.dto.RateRequest;
import com.VeraRchik.bankapplication.service.facade.ProductFacade;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/vBank")
@CrossOrigin(origins = "http://localhost:3000")
@PreAuthorize("hasAnyAuthority('USER', 'ADMIN')") //todo сделать в принципе авторизованный пользователь мог видеть транзакции и создавать их
public class ProductController {

    private final ProductFacade productFacade;

    @GetMapping("/getProduct/{id}")
    public ResponseEntity<ProductDto> getProduct(@PathVariable("id") Long id) {
        ProductDto productDto = productFacade.getProduct(id);
        return ResponseEntity.ok(productDto);
    }

    @GetMapping("/getProductAll")
    public ResponseEntity<List<ProductDto>> getProductAll() {
        List<ProductDto> productDtoList = productFacade.getProductAll();
        return ResponseEntity.ok(productDtoList);
    }

    @GetMapping("/getProductsUsers/{id}")
    public ResponseEntity<List<ProductDto>> getProductsByUser(@PathVariable("id") @NonNull Long id) {
        List<ProductDto> productDtoList = productFacade.getProductByUserId(id);
        return ResponseEntity.ok(productDtoList);
    }
    @PostMapping("/createProduct")
    public ResponseEntity<Void> createProduct(@RequestBody RateRequest rateRequest) {
        productFacade.createProduct(rateRequest.getRateId(), rateRequest.getUserId());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/deleteProduct/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("id") Long id) {
            productFacade.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }

}
