package com.um.service;

import com.um.domain.item.Item;
import com.um.domain.item.ItemRepository;
import com.um.domain.lineItem.LineItem;
import com.um.domain.lineItem.LineItemRepository;
import com.um.domain.user.UserRepository;
import com.um.domain.userOrder.UserOrder;
import com.um.domain.userOrder.UserOrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final LineItemRepository lineItemRepository;
    private final UserOrderRepository userOrderRepository;
    private final ItemRepository itemRepository;
    private final UserRepository userRepository;

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

    public String buyItem(int userId)
    {
        UserOrder cart = userOrderRepository.findById(userId)
                .orElseThrow(() -> new UsernameNotFoundException("카트를 찾을 수 없습니다."));
        cart.buyItem();
        List<LineItem> lineItemList = lineItemRepository.findByOrderId(cart.getOrderId());
        for ( LineItem lineItem : lineItemList)
        {
            lineItem.getItem().sellItem(lineItem.getQuantity());
        }
        userOrderRepository.save(UserOrder.builder()
                .user(userRepository.findById(userId)
                        .orElseThrow(() -> new UsernameNotFoundException("카트를 찾을 수 없습니다.")))
                .status("cart")
                .build());
        return "카트 구매 완료";
    }
}
