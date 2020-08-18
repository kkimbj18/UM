package com.um.service;

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

    @Transactional
    public int create(ProductCreateDto productCreateDto)
    {
        Product product =  productRepository.save(Product.builder()
            .name(productCreateDto.getName())
            .category1(productCreateDto.getCategory1())
            .category2(productCreateDto.getCategory2())
            .price(productCreateDto.getPrice())
            .build());

        return product.getProductId();
    }
    @Transactional
    public List<ProductResponseDto> getFindByName(String name)
    {
        List<Product> productList = productRepository.findAll();
        List<ProductResponseDto> response = new ArrayList<ProductResponseDto>();

        for(Product product : productList) {
            if(product.getName().contains(name)) {
                response.add(ProductResponseDto.builder()
                        .productId(product.getProductId())
                        .brandId(product.getBrandId())
                        .name(product.getName())
                        .rating(product.getRating())
                        .category1(product.getCategory1())
                        .category2(product.getCategory2())
                        .build());
            }
        }

        return response;
    }
}
