package com.um.web.controller;

import com.um.domain.brand.Brand;
import com.um.domain.brand.BrandRepository;
import com.um.domain.item.Item;
import com.um.domain.item.ItemRepository;
import com.um.domain.lineItem.LineItemRepository;
import com.um.domain.product.Product;
import com.um.domain.product.ProductRepository;
import com.um.domain.user.User;
import com.um.domain.user.UserRepository;
import com.um.domain.userOrder.UserOrder;
import com.um.domain.userOrder.UserOrderRepository;
import com.um.web.dto.LineItemCreateDto;
import org.hibernate.annotations.NaturalId;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BuyingControllerTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserOrderRepository userOrderRepository;
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private BrandRepository brandRepository;
    @Autowired
    private LineItemRepository lineItemRepository;
    @Before
    public void setUp()
    {
        userRepository.save(User.builder()
                .name("엄")
                .role(Collections.singletonList("ROLE_USER"))
                .name("엄")
                .account("엄")
                .address("um")
                .password("um")
                .phoneNumber("um")
                .build());
        userOrderRepository.save(UserOrder.builder()
                .status("cart")
                .user(userRepository.findAll().get(0))
                .build());
        brandRepository.save(Brand.builder()
                .user(userRepository.findAll().get(0))
                .name("um")
                .build());
        productRepository.save(Product.builder()
                .brand(brandRepository.findAll().get(0))
                .name("um")
                .category1("um")
                .category2("um")
                .price(15000)
                .build());
        itemRepository.save(Item.builder()
                .product(productRepository.findAll().get(0))
                .size(300)
                .remain(30)
                .color("um")
                .extraPrice(3000)
                .build());
    }

    @After
    public void cleanUp()
    {
        lineItemRepository.deleteAll();
        itemRepository.deleteAll();
        productRepository.deleteAll();
        brandRepository.deleteAll();
        userOrderRepository.deleteAll();
        userRepository.deleteAll();
    }

    @Test
    public void cartTest()
    {

        LineItemCreateDto lineItemCreateDto = LineItemCreateDto.builder()
                .itemId(1)
                .quantity((short)2)
                .userId(1)
                .build();
        HttpEntity<LineItemCreateDto> requestEntity = new HttpEntity<>(lineItemCreateDto);
        String url="http://localhost:"+port+"/item/cart";
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(lineItemRepository.findAll().get(0).getTotalPrice()).isEqualTo(36000);
    }
}
