package com.um.web.controller;

import com.um.domain.product.Product;
import com.um.domain.product.ProductRepository;
import com.um.service.ProductService;
import com.um.web.dto.ProductSearchDto;
import com.um.web.dto.ProductCreateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ProductController {

    private final ProductRepository productRepository;
    private final ProductService productService;

    @CrossOrigin
    @GetMapping("/search/name")
    public List<Product> searchByName(@RequestBody ProductSearchDto productSearchDto) {
        return productRepository.findByName(productSearchDto.getName());
    }
    @CrossOrigin
    @PostMapping("/Product/Test")
    public int productTest(@RequestBody ProductCreateDto productCreateDto) {
        productService.create(productCreateDto);

        return productCreateDto.getProductId();
    }
}
