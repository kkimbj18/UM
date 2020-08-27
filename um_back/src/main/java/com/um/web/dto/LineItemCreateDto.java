package com.um.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class LineItemCreateDto {
    private int userId;
    private int itemId;
    private short quantity;

    @Builder
    public LineItemCreateDto(int userId,int itemId,short quantity)
    {
        this.userId = userId;
        this.itemId = itemId;
        this.quantity = quantity;
    }
}
