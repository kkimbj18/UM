package com.um.web.controller;

import com.um.domain.brand.Brand;
import com.um.domain.brand.BrandRepository;
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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductControllerTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private BrandRepository brandRepository;
    @Autowired
    private UserRepository userRepository;

    @Before
    public void setup(){
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
    }
    @After
    public void cleanup(){
        productRepository.deleteAll();
        brandRepository.deleteAll();
        userRepository.deleteAll();
    }
    @Test
    public void productFilterTest(){
        String url = "http://localhost:" + port + "/search/filter/Top";
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);

        //assertThat(responseEntity.getBody()).isEqualTo("temp");
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
    @Test
    public void productSubFilterTest(){
        String url = "http://localhost:" + port + "/search/filter/sub/blouse";
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);

        //assertThat(responseEntity.getBody()).isEqualTo("temp");
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
    @Test
    public void productSearchTest(){
        String url = "http://localhost:" + port + "/search/su";
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);

        //assertThat(brandRepository.findAll()).isNotEmpty();
    }
    @Test
    public void productSearchPrice(){
        String url = "http://localhost:" + port + "/search/price/10000/20000";
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);

        //assertThat(responseEntity.getBody()).isEqualTo("temp");

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
}
