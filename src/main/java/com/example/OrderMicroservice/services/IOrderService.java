package com.example.OrderMicroservice.services;

import com.example.OrderMicroservice.dtos.CreateOrderResponseDTO;
import com.example.OrderMicroservice.dtos.OrderRequestDTO;

public interface IOrderService {
    CreateOrderResponseDTO createOrder(OrderRequestDTO requestDTO);
}
