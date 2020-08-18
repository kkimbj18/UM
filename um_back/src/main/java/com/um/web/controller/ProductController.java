package com.um.web.controller;

import com.um.domain.product.Product;
import com.um.domain.product.ProductRepository;
import com.um.service.ProductService;
import com.um.web.dto.ProductCreateDto;
import com.um.web.dto.ProductResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class ProductController {

    private final ProductRepository productRepository;
    private final ProductService productService;

    @CrossOrigin
    @GetMapping("/search/{name}")
    public List<ProductResponseDto> searchByName(@PathVariable("name") String name)throws SQLException {
        return productService.getFindByName(name);
    }
    @CrossOrigin
    @PostMapping("/Product/Test")
    public int productTest(@RequestBody ProductCreateDto productCreateDto) {
        int id = productService.create(productCreateDto);

        return id;
    }
    @CrossOrigin
    @GetMapping("/productCheck")
    public List<Product> check(){
        return productRepository.findAll();
    }
}
