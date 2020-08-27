package com.um.service;

import com.um.domain.item.Item;
import com.um.domain.item.ItemRepository;
import com.um.domain.lineItem.LineItem;
import com.um.domain.lineItem.LineItemRepository;
import com.um.domain.userOrder.UserOrder;
import com.um.domain.userOrder.UserOrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final LineItemRepository lineItemRepository;
    private final UserOrderRepository userOrderRepository;
    private final ItemRepository itemRepository;

    public String putItem(int itemId,int userId,short quantity){

        UserOrder cart = userOrderRepository.findById(userId)
                .orElseThrow(() -> new UsernameNotFoundException("카트를 찾을 수 없습니다."));
        Item item = itemRepository.findById(itemId)
                .orElseThrow(() -> new UsernameNotFoundException("아이템을 찾을 수 없습니다."));
        int totalPrice = (item.getProduct().getPrice()+item.getExtraPrice())*quantity;
        lineItemRepository.save(LineItem.builder()
                .order(cart)
                .item(item)
                .quantity(quantity)
                .totalPrice(totalPrice)
                .build());
        return "장바구니 담기 완료";
    }
}
