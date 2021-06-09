package com.university.confectionary.service;

import com.university.confectionary.domain.entities.OrderEntity;
import com.university.confectionary.domain.entities.ProductEntity;
import com.university.confectionary.dto.OrderDto;
import com.university.confectionary.dto.ProductOrderDto;
import com.university.confectionary.repositories.OrderRepository;
import com.university.confectionary.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;

    @Transactional
    public ResponseEntity<String> createOrder(OrderDto orderDto) {
        List<ProductEntity> productEntity = convertToEntity(orderDto.getProducts());

        OrderEntity orderEntity = OrderEntity.builder()
                .name(orderDto.getName())
                .surname(orderDto.getSurname())
                .email(orderDto.getEmail())
                .phone(orderDto.getPhone())
                .productList(productEntity)
                .build();

        OrderEntity created = orderRepository.save(orderEntity);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Order is created successfully");

    }

    private List<ProductEntity> convertToEntity(List<ProductOrderDto> products) {
        List<ProductEntity> productEntities = new ArrayList<>();
        for(int i =0; i< products.size(); i++){
            ProductEntity productEntity = productRepository.findProductEntityById(products.get(i).getId()).get();
            productEntities.add(productEntity);
        }
        return productEntities;
    }
}