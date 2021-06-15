package com.university.confectionary.service;

import com.university.confectionary.domain.entities.OrderEntity;
import com.university.confectionary.domain.entities.ProductEntity;
import com.university.confectionary.dto.CreatedOrderDto;
import com.university.confectionary.dto.OrderDto;
import com.university.confectionary.dto.ProductOrderDto;
import com.university.confectionary.dto.ProductOrderForAdminDto;
import com.university.confectionary.repositories.OrderRepository;
import com.university.confectionary.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class OrderService {
    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(ProductRepository productRepository, OrderRepository orderRepository) {
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
    }

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


    List<ProductEntity> convertToEntity(List<ProductOrderDto> products) {
        List<ProductEntity> productEntities = new ArrayList<>();
        for(int i =0; i< products.size(); i++){
            ProductEntity productEntity = productRepository.findProductEntityById(products.get(i).getId()).get();
            productEntities.add(productEntity);
        }
        return productEntities;
    }


    public Page<OrderEntity> findAllOrders(Pageable pageable) {
        return orderRepository.findAll(pageable);
    }

    public List<CreatedOrderDto> convertToDto(List<OrderEntity> list) {
        List<CreatedOrderDto> createdOrders = new ArrayList<>();

        for(int i =0; i< list.size(); i++){
            List<ProductOrderForAdminDto> productOrderDtos = new ArrayList<>();
            for(int j=0; j< list.get(i).getProductList().size();j++){

                ProductOrderForAdminDto productOrderDto = ProductOrderForAdminDto.builder()
                        .id(list.get(i).getProductList().get(j).getId())
                        .name(list.get(i).getProductList().get(j).getName())
                        .weight(list.get(i).getProductList().get(j).getWeight())
                        .price(list.get(i).getProductList().get(j).getPrice())
                        .build();
                productOrderDtos.add(productOrderDto);
            }

            CreatedOrderDto createdOrderDto = CreatedOrderDto.builder()
                    .id(list.get(i).getId())
                    .email(list.get(i).getEmail())
                    .name(list.get(i).getName())
                    .surname(list.get(i).getSurname())
                    .phone(list.get(i).getPhone())
                    .products(productOrderDtos)
                    .build();
            createdOrders.add(createdOrderDto);
        }
        return createdOrders;
    }
}