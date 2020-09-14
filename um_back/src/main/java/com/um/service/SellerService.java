package com.um.service;

import com.um.domain.brand.Brand;
import com.um.domain.brand.BrandRepository;
import com.um.domain.product.Product;
import com.um.domain.product.ProductRepository;
import com.um.domain.user.User;
import com.um.domain.user.UserRepository;
import com.um.web.dto.SellerSoldAmountResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SellerService {
    private final UserRepository userRepository;
    private final BrandRepository brandRepository;
    private final ProductRepository productRepository;

    @Transactional
    public List<SellerSoldAmountResponseDto> calSoldAmount(int id) {
        List<SellerSoldAmountResponseDto> list = new ArrayList<>();

        User me = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다"));
        Brand myBrand = brandRepository.findByUser_UserId(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자는 등록한 브랜드가 없습니다"));
        List<Product> products = productRepository.findByBrand_BrandId(myBrand.getBrandId());

        if(products.isEmpty()) throw new IllegalArgumentException("아직 등록된 물품이 없습니다");

        for(Product product : products){
            list.add(SellerSoldAmountResponseDto.builder()
                    .id(product.getProductId())
                    .quantity(product.getSoldAmount())
                    .build());
        }

        return list;
    }
    /*
    @Transactional
    public List<SellerSoldAmountResponseDto> calSoldAmount(int id) {
        Brand myBrand = new Brand();
        List<SellerSoldAmountResponseDto> list = new ArrayList<>();

        User me = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다"));
        List<Brand> brands = brandRepository.findAll();
        for(Brand brand : brands){
            if(brand.getUserId() == id)
                myBrand = brand;
        }
        List<Product> products = productRepository.findAll();

        for (Product product : products) {
            if(product.getBrandId() == myBrand.getBrandId()) {
                list.add(SellerSoldAmountResponseDto.builder()
                        .id(product.getProductId())
                        .quantity(product.getSoldAmount())
                        .build());
            }
        }

        return list;
    }
     */
    @Transactional
    public int calMyProfit(int id){
        int profit = 0;

        User me = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다"));

        Brand myBrand = brandRepository.findByUser_UserId(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자는 등록한 브랜드가 없습니다"));

        List<Product> products = productRepository.findByBrand_BrandId(myBrand.getBrandId());

        if(products.isEmpty()) throw new IllegalArgumentException("아직 등록된 물품이 없습니다");

        for(Product product : products)
                profit += product.getPrice() * product.getSoldAmount();

        return profit;
    }
/*
    @Transactional
    public int calMyProfit(int id){
        Brand myBrand = new Brand();

        int profit = 0;

        User me = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다"));

        List<Brand> brands = brandRepository.findAll();

        for(Brand brand : brands){
            if(brand.getUserId() == id)
                myBrand = brand;
        }

        List<Product> products = productRepository.findAll();

        for(Product product : products){
            if(product.getBrandId() == myBrand.getBrandId()) {
                profit += product.getPrice() * product.getSoldAmount();
            }
        }

        return profit;
    }

 */
}
