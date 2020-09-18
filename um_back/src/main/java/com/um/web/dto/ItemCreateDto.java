package com.um.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ItemCreateDto {
    private int itemId;
    private int productId;
    private int size;
    private String color;
    private int extraPrice;

    @Builder
    public ItemCreateDto(int itemId,int productId,int size,String color,int extraPrice)
    {
        this.itemId = itemId;
        this.productId = productId;
        this.size = size;
        this.color = color;
        this.extraPrice = extraPrice;
    }
}
