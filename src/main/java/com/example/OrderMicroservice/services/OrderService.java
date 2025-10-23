package com.example.OrderMicroservice.services;

import com.example.OrderMicroservice.clients.ProductServiceClient;
import com.example.OrderMicroservice.dtos.CreateOrderResponseDTO;
import com.example.OrderMicroservice.dtos.OrderItemDTO;
import com.example.OrderMicroservice.dtos.OrderRequestDTO;
import com.example.OrderMicroservice.dtos.ProductDTO;
import com.example.OrderMicroservice.entity.Order;
import com.example.OrderMicroservice.entity.OrderItem;
import com.example.OrderMicroservice.enums.OrderStatus;
import com.example.OrderMicroservice.mappers.OrderItemMapper;
import com.example.OrderMicroservice.mappers.OrderMapper;
import com.example.OrderMicroservice.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService implements  IOrderService{
    private final OrderRepository orderRepository;
    private final ProductServiceClient productServiceClient;
    public OrderService(OrderRepository orderRepository, ProductServiceClient productServiceClient){
        this.orderRepository = orderRepository;
        this.productServiceClient = productServiceClient;
    }
    @Override
    public CreateOrderResponseDTO createOrder(OrderRequestDTO requestDTO) {
        // Persist the order in order table > OrderRequestDTO> Order Entity
        Order order = OrderMapper.toEntity(requestDTO);
        List<OrderItem> orderList = new ArrayList<>();
        for(OrderItemDTO item: requestDTO.getItems()){
            // fetch the product details for every item
            // according to me :-> we can optimize this by fetching the list of all product id and put them into the map and we can access them from map not from api call all the time
            ProductDTO product = productServiceClient.getProductById(item.getProductId());
            double pricePerUnit = product.getPrice();
            double totalPrice = pricePerUnit * item.getQuantity();
            OrderItem items = OrderItemMapper.OrderItemRequestDTOtoOrderItemEntity(item,order,pricePerUnit,totalPrice);
            orderList.add(items);
        }
        order.setOrderItemList(orderList);
        // currently by just doing this order_items table data is not populated. this commit is to track change, exactly what changes needed to make this work..
        // concept of cascading is introduced
        Order createdOrder = orderRepository.save(order);
        return OrderMapper.toCreateOrderResponseDTO(createdOrder);
    }
}
