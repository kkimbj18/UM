package com.um.service;

import com.um.domain.product.Product;
import com.um.domain.product.ProductRepository;
import com.um.web.dto.ProductCreateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    @Transactional
    public void create(ProductCreateDto productCreateDto)
    {
        productRepository.save(Product.builder()
            .name(productCreateDto.getName())
            .rating(productCreateDto.getRating())
            .category1(productCreateDto.getCategory1())
            .category2(productCreateDto.getCategory2())
            .build());
    }
}
