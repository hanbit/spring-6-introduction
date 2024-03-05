package com.example.shopping.repository;

import com.example.shopping.entity.Order;

public class JdbcOrderRepository implements OrderRepository {
    @Override
    public void insert(Order order) {
        if (order == null) {
            throw new IllegalArgumentException("인수가 바르지 않습니다.");
        }
        System.out.println("주문을 등록했습니다. id=" + order.getId());
    }
}
