package com.um.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProductSearchDto {
    private String name;

    @Builder
    public ProductSearchDto(String name){
        this.name = name;
    }
}
