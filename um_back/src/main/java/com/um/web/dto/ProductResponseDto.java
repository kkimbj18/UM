package com.um.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProductResponseDto {
    private int productId;
    private int brandId;
    private String name;
    private double rating;
    private String category1;
    private String category2;
    private int price;

    @Builder
    public ProductResponseDto(int productId, int brandId, String name, double rating, String category1, String category2, int price){
        this.productId = productId;
        this.brandId = brandId;
        this.name = name;
        this.rating = rating;
        this.category1 = category1;
        this.category2 = category2;
        this.price = price;
    }
}
