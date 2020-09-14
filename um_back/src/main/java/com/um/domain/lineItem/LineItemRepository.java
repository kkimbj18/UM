package com.um.domain.lineItem;

import com.um.domain.userOrder.UserOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LineItemRepository extends JpaRepository<LineItem , Integer> {
    List<LineItem> findByOrder(UserOrder userOrder);
}
