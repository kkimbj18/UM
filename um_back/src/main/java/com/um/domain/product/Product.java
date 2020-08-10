package com.um.domain.product;

import com.um.domain.brand.Brand;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Table(name="product")
public class Product {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brandId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private short rating;

    @Column(nullable = false)
    private String category1;

    @Column(nullable = false)
    private String category2;

    @Column(nullable = false)
    private int soldAmount;
}
