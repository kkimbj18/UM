package com.um.domain.product;

import com.um.domain.brand.Brand;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@Table(name="product")
public class Product {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;

    @ManyToOne
    @JoinColumn(name = "brandId")
    private Brand brand;


    @Column(nullable = false)
    private String name;

    @Column()
    private double rating;

    @Column(nullable = false)
    private String category1;

    @Column(nullable = false)
    private String category2;

    @Column()
    private int soldAmount;

    @Column(nullable = false)
    private int price;

    /*
    @lob
    @Column
    private thumbnail;

    @lob
    @Column
    private descriptionImage;
     */

    public int getBrandId(){ return brand.getBrandId(); }
}
