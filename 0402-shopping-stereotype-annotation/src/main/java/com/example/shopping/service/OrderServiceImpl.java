package com.example.shopping.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.example.shopping.entity.Order;
import com.example.shopping.entity.OrderItem;
import com.example.shopping.entity.Product;
import com.example.shopping.exception.StockShortageException;
import com.example.shopping.input.CartInput;
import com.example.shopping.input.CartItemInput;
import com.example.shopping.input.OrderInput;
import com.example.shopping.repository.OrderItemRepository;
import com.example.shopping.repository.OrderRepository;
import com.example.shopping.repository.ProductRepository;

public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;
    private final ProductRepository productRepository;

    public OrderServiceImpl(OrderRepository orderRepository, OrderItemRepository orderItemRepository, ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.orderItemRepository = orderItemRepository;
        this.productRepository = productRepository;
    }

    @Override
    public Order placeOrder(OrderInput orderInput, CartInput cartInput) {
        // Repository에 넘겨줄 주문 객체를 생성한다
        Order order = new Order();
        // ID는 UUID(Universally Unique Identifier. 랜덤한 ID를 생성할 때 이용되는 표준 기술)을 사용
        order.setId(UUID.randomUUID().toString());
        // 넘어온  주문 정보(OrderInput)를 Order 객체에 저장
        order.setCustomerName(orderInput.getName());
        order.setCustomerAddress(orderInput.getAddress());
        order.setCustomerPhone(orderInput.getPhone());
        order.setCustomerEmailAddress(orderInput.getEmailAddress());
        order.setOrderDateTime(LocalDateTime.now());
        order.setPaymentMethod(orderInput.getPaymentMethod());
        // 합계금액(세금불포함)을 계산한다
        int totalAmount = calculateTotalAmount(cartInput.getCartItemInputs());
        // 청구금액(세금포함)을 계산한다
        int billingAmount = calculateTax(totalAmount);
        order.setBillingAmount(billingAmount);
        // 주문 데이터를 데이터베이스에 삽입
        orderRepository.insert(order);
        List<OrderItem> orderItems = new ArrayList<>();
        // 장바구니 안의 상품 수만큼 반복한다
        for (CartItemInput cartItem : cartInput.getCartItemInputs()) {
            // 상품 데이터를 데이터베이스에서 가져온다
            Product product = productRepository.selectById(cartItem.getProductId());
            int afterStock = product.getStock() - cartItem.getQuantity();
            // 재고가 부족한 경우는 예외를 던진다
            if (afterStock < 0) {
                throw new StockShortageException("재고가 없습니다.");
            }
            // 재고 갱신
            product.setStock(afterStock);
            // 데이터베이스의 상품 데이터 갱신
            productRepository.update(product);
            // Repository에 넘겨줄 주문 내역 객체를 생성. 수량 등을 저장
            OrderItem orderItem = new OrderItem();
            orderItem.setId(UUID.randomUUID().toString());
            orderItem.setOrderId(order.getId());
            orderItem.setProductId(product.getId());
            orderItem.setPriceAtOrder(cartItem.getProductPrice());
            orderItem.setQuantity(cartItem.getQuantity());
            // 주문 내역 데이터를 데이터베이스에 삽입
            orderItemRepository.insert(orderItem);
            orderItems.add(orderItem);
        }
        order.setOrderItems(orderItems);
        // 주문 처리 후 Order 객체를 반환값으로 반환한다
        return order;
    }

    private int calculateTotalAmount(List<CartItemInput> cartItems) {
        int totalAmount = 0;
        for (CartItemInput cartItem : cartItems) {
            totalAmount += (cartItem.getProductPrice() * cartItem.getQuantity());
        }
        return totalAmount;
    }

    private int calculateTax(int price) {
        return (int) (price * 1.1);
    }
}