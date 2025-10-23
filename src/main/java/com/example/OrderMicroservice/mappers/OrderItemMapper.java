package com.example.OrderMicroservice.mappers;

import com.example.OrderMicroservice.dtos.OrderItemDTO;
import com.example.OrderMicroservice.dtos.ProductDTO;
import com.example.OrderMicroservice.entity.Order;
import com.example.OrderMicroservice.entity.OrderItem;

public class OrderItemMapper {

    public static OrderItem OrderItemRequestDTOtoOrderItemEntity(OrderItemDTO item, Order order, double pricePerUnit, double totalPrice){
        return OrderItem.builder()
                .productId(item.getProductId())
                .pricePerUnit(pricePerUnit)
                .quantity(item.getQuantity())
                .totalPrice(totalPrice)
                .order(order)
                .build();
    }
}
