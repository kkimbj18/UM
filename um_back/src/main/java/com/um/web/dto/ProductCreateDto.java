package com.um.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProductCreateDto {
    private int productId;
    private String name;
    private short rating;
    private String category1;
    private String category2;

    @Builder
    public ProductCreateDto(String name, short rating, String category1, String category2)
    {
        this.name = name;
        this.rating = rating;
        this.category1 = category1;
        this.category2 = category2;
    }
}
