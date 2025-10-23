package com.example.OrderMicroservice.mappers;

import com.example.OrderMicroservice.dtos.CreateOrderResponseDTO;
import com.example.OrderMicroservice.dtos.OrderRequestDTO;
import com.example.OrderMicroservice.entity.Order;
import com.example.OrderMicroservice.enums.OrderStatus;

public class OrderMapper {

    public static Order toEntity(OrderRequestDTO dto){
        return Order.builder()
                .userId(dto.getUserId())
                .status(OrderStatus.PENDING)
                .build();
    }
    public static CreateOrderResponseDTO toCreateOrderResponseDTO(Order order){
        return CreateOrderResponseDTO.builder()
                .orderId(order.getId())
                .status(order.getStatus())
                .build();
    }
}
