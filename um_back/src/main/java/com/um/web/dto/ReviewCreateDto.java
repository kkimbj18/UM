package com.um.web.dto;

import com.um.domain.item.Item;
import com.um.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ReviewCreateDto {
    private int userId;
    private int itemId;
    private String content;
    private short rating;
    private String photo;

    @Builder
    public ReviewCreateDto(int userId, int itemId, String content, short rating, String photo){
        this.userId = userId;
        this.itemId = itemId;
        this.content = content;
        this.rating = rating;
        this.photo = photo;
    }

}
