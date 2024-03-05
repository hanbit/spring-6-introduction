
package com.example.shopping.repository;

import com.example.shopping.entity.OrderItem;

public class JdbcOrderItemRepository implements OrderItemRepository {

    @Override
    public void insert(OrderItem orderItem) {
        if (orderItem == null) {
            throw new IllegalArgumentException("인수가 바르지 않습니다.");
        }
        System.out.println("주문 내역을 등록했습니다. id=" + orderItem.getId());
    }
}
