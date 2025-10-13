package com.example.OrderMicroservice.controllers;

import com.example.OrderMicroservice.dtos.CreateOrderResponseDTO;
import com.example.OrderMicroservice.dtos.OrderRequestDTO;
import com.example.OrderMicroservice.services.IOrderService;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final IOrderService orderService;

    public OrderController(IOrderService orderService){
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<CreateOrderResponseDTO> createOrder(@RequestBody OrderRequestDTO request){
        CreateOrderResponseDTO order = orderService.createOrder(request);
        return ResponseEntity.ok(order);
    }
}
