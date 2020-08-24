package com.um.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
public class ProductCreateDto {
    private String name;
    private int brandId;
    private String category1;
    private String category2;
    private int price;

    @Builder
    public ProductCreateDto(String name, int brandId, String category1, String category2, int price){
        this.name = name;
        this.brandId = brandId;
        this.category1 = category1;
        this.category2 = category2;
        this.price = price;
    }
}
