package com.jrock.orderservice.service;

import com.jrock.orderservice.dto.OrderDto;
import com.jrock.orderservice.jpa.OrderEntity;
import com.jrock.orderservice.jpa.OrderRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    /**
     * 주문을 생성한다.
     */
    @Override
    public OrderDto createOrder(OrderDto orderDto) {

        orderDto.setOrderId(UUID.randomUUID().toString());

        orderDto.setTotalPrice(orderDto.getQty() * orderDto.getUnitPrice()); // 수량 * 단가

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT); // 엄격하게 변환

        OrderEntity orderEntity = modelMapper.map(orderDto, OrderEntity.class); // Map To Map

        orderRepository.save(orderEntity);

        OrderDto returnValue = modelMapper.map(orderEntity, OrderDto.class);

        return returnValue;
    }

    /**
     * 주문 정보를 가져온다.
     */
    @Override
    public OrderDto getOrderByOrderId(String orderId) {
        OrderEntity orderEntity = orderRepository.findByOrderId(orderId);
        OrderDto orderDto = new ModelMapper().map(orderEntity, OrderDto.class);

        return orderDto;
    }

    /**
     * user id 를 가지고 주문 정보를 조회한다.
     */
    @Override
    public Iterable<OrderEntity> getOrdersByUserId(String userId) {
        return orderRepository.findByUserId(userId);
    }
}
