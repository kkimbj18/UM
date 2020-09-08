package com.um.web.controller;

import com.um.domain.brand.Brand;
import com.um.domain.brand.BrandRepository;
import com.um.domain.product.Product;
import com.um.domain.product.ProductRepository;
import com.um.domain.user.User;
import com.um.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

class statistics{
    int id;
    int quantity;
}
@RequiredArgsConstructor
@RestController
public class SellerController {
    private final UserRepository userRepository;
    private final BrandRepository brandRepository;
    private final ProductRepository productRepository;

    @CrossOrigin
    @GetMapping("/seller/{id}/statistics")
    public List<statistics> checkSoldQuantity(@PathVariable("id") int id){
        List<statistics> list = new ArrayList<>();

        statistics s;

        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다"));
        Brand brand = brandRepository.findByUserId(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자는 가지고 있는 브랜드가 없습니다"));
        List<Product> productList = productRepository.findByBrandId(brand.getBrandId());

        if(productList.isEmpty()) throw new IllegalArgumentException("해당 사용자는 현재 등록한 물품이 없습니다");

        for(Product product : productList){
            s = new statistics();
            s.id = product.getProductId();
            s.quantity = product.getSoldAmount();
            list.add(s);
        }

        return list;
    }

    @CrossOrigin
    @GetMapping("/seller/{id}/profit")
    public int checkMyProfit(@PathVariable("id") int id){
        int profit = 0;

        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다"));
        Brand brand = brandRepository.findByUserId(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자는 가지고 있는 브랜드가 없습니다"));
        List<Product> productList = productRepository.findByBrandId(brand.getBrandId());

        if(productList.isEmpty()) throw new IllegalArgumentException("해당 사용자는 현재 등록한 물품이 없습니다");

        for(Product product : productList){
            profit += product.getPrice() * product.getSoldAmount();
        }

        return profit;
    }

}
