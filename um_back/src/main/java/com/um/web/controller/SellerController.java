package com.um.web.controller;

import com.um.service.SellerService;
import com.um.web.dto.SellerSoldAmountResponseDto;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class SellerController {
    private final SellerService sellerService;

    @CrossOrigin
    @GetMapping("/seller/{id}/statistics")
    public List<SellerSoldAmountResponseDto> checkSoldQuantity(@PathVariable("id") int id){

        return sellerService.calSoldAmount(id);
    }

    @CrossOrigin
    @GetMapping("/seller/{id}/profit")
    public int checkMyProfit(@PathVariable("id") int id){
        return sellerService.calMyProfit(id);
    }

}
