package com.um.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProductCreateDto {
    private String name;
    private String category1;
    private String category2;

    @Builder
    public ProductCreateDto(String name, String category1, String category2)
    {
        this.name = name;
        this.category1 = category1;
        this.category2 = category2;
    }
}
