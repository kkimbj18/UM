package com.um.web.controller;

import com.um.service.ItemService;
import com.um.web.dto.LineItemCreateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class BuyingController {

    private final ItemService itemService;

    @CrossOrigin
    @PostMapping("/item/cart")
    public String putItem(@RequestBody LineItemCreateDto lineItemCreateDto)
    {
        return itemService.putItem(lineItemCreateDto.getItemId(),lineItemCreateDto.getUserId(),lineItemCreateDto.getQuantity());
    }
}
