package com.um.web.controller;

import com.um.domain.product.Product;
import com.um.domain.product.ProductRepository;
import com.um.service.ProductService;
import com.um.web.dto.ItemCreateDto;
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
    // 이름으로 제품 검색
    @CrossOrigin
    @GetMapping("/search/{name}")
    public List<ProductResponseDto> searchByName(@PathVariable("name") String name)throws SQLException {

        return productService.findByName(name);
    }
    // 제품 생성 API
    @CrossOrigin
    @PostMapping("/Product/create")
    public int productCreate(@RequestBody ProductCreateDto productCreateDto) {
        return productService.createProduct(productCreateDto);
    }
    @CrossOrigin
    @PostMapping("item/create")
    public String itemCreate(@RequestBody ItemCreateDto itemCreateDto){
        return productService.createItem(itemCreateDto);
    }
    // 모든 제품 확인
    @CrossOrigin
    @GetMapping("/productCheck")
    public List<Product> check(){
        return productRepository.findAll();
    }
    // 대분류 카테고리로 제품 검색
    @CrossOrigin
    @GetMapping("/search/filter/{category1}")
    public List<ProductResponseDto> searchByFilter(@PathVariable("category1") String category1)throws SQLException {
        return productService.findByFilter(category1);
    }
    // 소분류 카테고리로 제품 검색
    @CrossOrigin
    @GetMapping("/search/filter/sub/{category2}")
    public List<ProductResponseDto> searchBySubFilter(@PathVariable("category2") String category2)throws SQLException {
        return productService.findBySubFilter(category2);
    }
    // 가격대로 제품 검색 ( ~ing )
    @CrossOrigin
    @GetMapping("/search/price/{price1}/{price2}")
    public List<ProductResponseDto> searchByCost(@PathVariable("price1") int price1,
                                                 @PathVariable("price2") int price2) throws SQLException {
        return productService.findByPrice(price1, price2);
    }
}