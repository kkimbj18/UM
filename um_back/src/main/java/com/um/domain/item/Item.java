package com.um.domain.item;

import com.um.domain.product.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name="item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int itemId;

    @ManyToOne
    @JoinColumn(name="product_id")
    private Product product;

    @Column(nullable = false)
    private int size;

    @Column(nullable = false)
    private String color;

    @Column(nullable = false)
    private int extraPrice;

    @Column(nullable = false)
    private int remain;

    public void sellItem(int amount){
        this.remain = this.remain - amount;
    }

    /*
    @lob
    @column
    private Clob image;
     */
}
