package com.um.web.controller;

import com.um.domain.product.Product;
import com.um.domain.product.ProductRepository;
import com.um.web.dto.ProductSearchDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ProductController {
    private final ProductRepository productRepository;

    @CrossOrigin
    @GetMapping("/search/name")
    public List<Product> searchByName(@RequestBody ProductSearchDto productSearchDto) {
        return productRepository.findByProductName(productSearchDto.getName());
    }
/*
    @CrossOrigin
    @PostMapping("/Product/Test")
    public int productTest(@RequestBody) {

    }

 */


}
