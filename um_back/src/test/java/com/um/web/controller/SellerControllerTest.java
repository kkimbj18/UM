package com.um.web.controller;

import com.um.domain.brand.Brand;
import com.um.domain.brand.BrandRepository;
import com.um.domain.item.Item;
import com.um.domain.item.ItemRepository;
import com.um.domain.product.Product;
import com.um.domain.product.ProductRepository;
import com.um.domain.user.User;
import com.um.domain.user.UserRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SellerControllerTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BrandRepository brandRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ItemRepository itemRepository;

    @Before
    public void setUp(){
        userRepository.save(User.builder()
                .account("sex")
                .password("1234")
                .name("mg")
                .address("ajouU")
                .phoneNumber("0102748476")
                .role(Collections.singletonList("ROLE_USER"))
                .build());

        brandRepository.save(Brand.builder()
                .user(userRepository.findAll().get(0))
                .name("Tw")
                .build());

        productRepository.save(Product.builder()
                .brand(brandRepository.findAll().get(0))
                .name("socks")
                .category1("Top")
                .category2("T-shirt")
                .price(20000)
                .build());
        productRepository.save(Product.builder()
                .brand(brandRepository.findAll().get(0))
                .name("sucks")
                .category1("Top")
                .category2("blouse")
                .price(30000)
                .build());
        productRepository.save(Product.builder()
                .brand(brandRepository.findAll().get(0))
                .name("xucks")
                .category1("pants")
                .category2("Blue Jeans")
                .price(15000)
                .build());
        productRepository.save(Product.builder()
                .brand(brandRepository.findAll().get(0))
                .name("sus")
                .category1("Accessory")
                .category2("socks")
                .price(10000)
                .build());
        itemRepository.save(Item.builder()
                .product(productRepository.findAll().get(0))
                .color("red")
                .size(95)
                .extraPrice(0)
                .remain(200)
                .build());
        itemRepository.save(Item.builder()
                .product(productRepository.findAll().get(1))
                .color("black")
                .size(100)
                .extraPrice(5000)
                .remain(0)
                .build());
    }
    @After
    public void cleanUp(){
        itemRepository.deleteAll();
        productRepository.deleteAll();
        brandRepository.deleteAll();
        userRepository.deleteAll();
    }
    @Test
    public void checkSoldAmountTest(){
        
    }
    @Test
    public void checkMyProfitTest(){

    }
}
