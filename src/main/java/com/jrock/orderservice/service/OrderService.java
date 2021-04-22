package com.jrock.orderservice.service;

import com.jrock.orderservice.dto.OrderDto;
import com.jrock.orderservice.jpa.OrderEntity;

public interface OrderService {
    OrderDto createOrder(OrderDto orderDetails);

    OrderDto getOrderByOrderId(String orderId);

    Iterable<OrderEntity> getOrdersByUserId(String userId);
}
