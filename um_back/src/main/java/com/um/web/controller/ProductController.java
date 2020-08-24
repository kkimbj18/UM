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

        return productService.findByName(name);
    }

    @CrossOrigin
    @PostMapping("/Product/Test")
    public int productTest(@RequestBody ProductCreateDto productCreateDto) {

        return productService.create(productCreateDto);
    }

    @CrossOrigin
    @GetMapping("/productCheck")
    public List<Product> check(){
        return productRepository.findAll();
    }

    @CrossOrigin
    @GetMapping("/search/filter/{category1}")
    public List<ProductResponseDto> searchByFilter(@PathVariable("category1") String category1)throws SQLException {
        return productService.findByFilter(category1);
    }

    @CrossOrigin
    @GetMapping("/search/filter/sub/{category2}")
    public List<ProductResponseDto> searchBySubFilter(@PathVariable("category2") String category2)throws SQLException {
        return productService.findBySubFilter(category2);
    }

    @CrossOrigin
    @GetMapping("/search/price/{price}")
    public List<ProductResponseDto> searchByCost(@PathVariable("price") int price) throws SQLException {
        return productService.findByPrice(price);
    }
}
