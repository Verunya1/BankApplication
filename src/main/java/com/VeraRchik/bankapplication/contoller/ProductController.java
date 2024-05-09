package com.VeraRchik.bankapplication.contoller;

import com.VeraRchik.bankapplication.dto.ProductDto;
import com.VeraRchik.bankapplication.dto.RateRequest;
import com.VeraRchik.bankapplication.entity.Product;
import com.VeraRchik.bankapplication.service.facade.ProductFacade;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/vBank")
@CrossOrigin(origins = "http://localhost:3000")
public class ProductController {

    private final ProductFacade productFacade;

    @GetMapping("/getProduct")
    public ResponseEntity<ProductDto> getProduct(@RequestParam("id") Long id) {
        ProductDto productDto = productFacade.getProduct(id);
        return ResponseEntity.ok(productDto);
    }

    @GetMapping("/getProductAll")
    public ResponseEntity<List<ProductDto>> getProductAll() {
        List<ProductDto> productDtoList = productFacade.getProductAll();
        return ResponseEntity.ok(productDtoList);
    }

    @PostMapping("/createProduct")
    public ResponseEntity<Void> createProduct(@RequestBody RateRequest rateRequest) {
        productFacade.createProduct(rateRequest.getRateId());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
// @PostMapping("/createProduct")
//    public ResponseEntity<Void> createProduct(@RequestBody Product product) {
//        productFacade.createProduct(product);
//        return ResponseEntity.status(HttpStatus.CREATED).build();
//    }


    @DeleteMapping("/deleteProduct/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("id") Long id) {
            productFacade.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }

}
