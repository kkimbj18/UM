package com.um.service;

import com.um.domain.brand.Brand;
import com.um.domain.brand.BrandRepository;
import com.um.domain.product.Product;
import com.um.domain.product.ProductRepository;
import com.um.web.dto.ProductCreateDto;
import com.um.web.dto.ProductResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final BrandRepository brandRepository;

    @Transactional
    public int create(ProductCreateDto productCreateDto)
    {
        Brand brand = brandRepository.findById(productCreateDto.getBrandId())
                .orElseThrow(() -> new IllegalArgumentException(
                        "해당 브랜드 명이 존재하지 않습니다. (BrandId : " + productCreateDto.getBrandId() + ")"));

        Product product =  productRepository.save(Product.builder()
            .brand(brand)
            .name(productCreateDto.getName())
            .category1(productCreateDto.getCategory1())
            .category2(productCreateDto.getCategory2())
            .price(productCreateDto.getPrice())
            .build());

        return product.getProductId();
    }
    @Transactional
    public List<ProductResponseDto> findByName(String name)
    {
        List<Product> productList = productRepository.findAll();
        List<ProductResponseDto> response = new ArrayList<ProductResponseDto>();

        for(Product product : productList) {
            if(product.getName().contains(name)) {
                response.add(ProductResponseDto.builder()
                        .productId(product.getProductId())
                        .brandId(product.getBrandId())
                        .name(product.getName())
                        .price(product.getPrice())
                        .rating(product.getRating())
                        .category1(product.getCategory1())
                        .category2(product.getCategory2())
                        .build());
            }
        }

        return response;
    }
    @Transactional
    public List<ProductResponseDto> findByFilter(String category1)
    {
        List<Product> productList = productRepository.findAll();
        List<ProductResponseDto> response = new ArrayList<>();

        for(Product product : productList) {
            if (product.getCategory1().equals(category1)) {
                response.add(ProductResponseDto.builder()
                        .productId(product.getProductId())
                        .brandId(product.getBrandId())
                        .name(product.getName())
                        .price(product.getPrice())
                        .rating(product.getRating())
                        .category1(product.getCategory1())
                        .category2(product.getCategory2())
                        .build());
            }
        }

        return response;
    }
    @Transactional
    public List<ProductResponseDto> findBySubFilter(String category2)
    {
        List<Product> productList = productRepository.findAll();
        List<ProductResponseDto> response = new ArrayList<>();

        for(Product product : productList) {
            if (product.getCategory2().equals(category2)) {
                response.add(ProductResponseDto.builder()
                        .productId(product.getProductId())
                        .brandId(product.getBrandId())
                        .name(product.getName())
                        .price(product.getPrice())
                        .rating(product.getRating())
                        .category1(product.getCategory1())
                        .category2(product.getCategory2())
                        .build());
            }
        }

        return response;
    }
    @Transactional
    public List<ProductResponseDto> findByPrice(int price1, int price2)
    {
        List<Product> productList = productRepository.findAll();
        List<ProductResponseDto> response = new ArrayList<>();

        for(Product product : productList) {
            if(product.getPrice() <= price2 && product.getPrice() >= price1)
            {
                response.add(ProductResponseDto.builder()
                        .productId(product.getProductId())
                        .brandId(product.getBrandId())
                        .name(product.getName())
                        .price(product.getPrice())
                        .rating(product.getRating())
                        .category1(product.getCategory1())
                        .category2(product.getCategory2())
                        .build());
            }
        }
        return response;
    }
}