package com.example.OrderMicroservice.dtos;

import com.example.OrderMicroservice.enums.OrderStatus;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateOrderResponseDTO {
    private Long orderId;
    private OrderStatus status;
}
