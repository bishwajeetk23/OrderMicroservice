package com.example.OrderMicroservice.services;

import com.example.OrderMicroservice.dtos.CreateOrderResponseDTO;
import com.example.OrderMicroservice.dtos.OrderRequestDTO;
import com.example.OrderMicroservice.entity.Order;
import com.example.OrderMicroservice.repository.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderService implements  IOrderService{
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }
    @Override
    public CreateOrderResponseDTO createOrder(OrderRequestDTO requestDTO) {
        // Persist the order in order table
        Order order = new Order();
    }
}
