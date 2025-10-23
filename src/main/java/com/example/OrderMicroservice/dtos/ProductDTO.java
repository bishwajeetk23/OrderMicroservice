package com.example.OrderMicroservice.dtos;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDTO {
    private String image;
    private String color;
    private int price;
    private String description;
    private int discount;
    private String model;
    private String title;
    private String brand;
    private boolean popular;
    private Long id;
    private Long categoryId;
}
