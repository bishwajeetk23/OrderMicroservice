package com.example.OrderMicroservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class OrderItem extends BaseEntity{

    @ManyToOne
    @JoinColumn()
    String orderId;
}
