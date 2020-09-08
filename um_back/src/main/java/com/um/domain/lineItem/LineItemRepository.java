package com.um.domain.lineItem;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LineItemRepository extends JpaRepository<LineItem , Integer> {
    List<LineItem> findByOrderId(int orderId);
}
