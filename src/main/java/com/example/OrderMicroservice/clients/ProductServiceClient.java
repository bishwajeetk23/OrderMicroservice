package com.example.OrderMicroservice.clients;

import com.example.OrderMicroservice.dtos.ProductDTO;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ProductServiceClient {
    private final RestTemplateBuilder restTemplateBuilder;

    public ProductServiceClient(RestTemplateBuilder restTemplateBuilder){
        this.restTemplateBuilder = restTemplateBuilder;
    }
    public ProductDTO getProductById(Long productId){
        RestTemplate restTemplate = restTemplateBuilder.build();
        String url = "http://localhost:3000/api/products/" + productId;
        ResponseEntity<ProductDTO> response = restTemplate.getForEntity(url, ProductDTO.class);
        return response.getBody();
    }
}
