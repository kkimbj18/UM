package com.um.domain.lineItem;

import com.um.domain.userOrder.UserOrder;
import com.um.domain.item.Item;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="lineItem")
public class LineItem {
    @Id
    @Column(name="lineItem")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "orderId")
    private UserOrder order;

    @ManyToOne
    @JoinColumn(name = "itemId")
    private Item item;

    @Column(name = "quantity")
    private short quantity;

    @Column(name = "total_price")
    private int totalPrice;

}
