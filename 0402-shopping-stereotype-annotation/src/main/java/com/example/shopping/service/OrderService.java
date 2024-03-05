package com.example.shopping.service;

import com.example.shopping.entity.Order;
import com.example.shopping.input.CartInput;
import com.example.shopping.input.OrderInput;

public interface OrderService {
    Order placeOrder(OrderInput orderInput, CartInput cartInput);
}
