/*package com.university.confectionary.service;

import com.university.confectionary.domain.entities.OrderEntity;
import com.university.confectionary.domain.entities.ProductEntity;
import com.university.confectionary.dto.OrderDto;
import com.university.confectionary.dto.ProductDetailsDto;
import com.university.confectionary.dto.ProductOrderDto;
import junit.framework.TestCase;
import org.aspectj.weaver.ast.Or;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest
public class OrderServiceTest {

    @Autowired
    public OrderService orderService;

    @Test
    public void testCreateOrder() {
        List<ProductOrderDto> products = new ArrayList<>();
        products.add(new ProductOrderDto(1));
        products.add(new ProductOrderDto(2));

        OrderDto order = new OrderDto("Alice","Green","alice@gmail.com","0994746593", products);

        String response = orderService.createOrder(order).getBody();

        assertEquals("Order is created successfully",response);
    }

    @Test
    public void testConvertToDto() {
        List<ProductEntity> products = new ArrayList<>();
        ProductEntity entity1 = new ProductEntity(2, "Cupcake", 120, 12, "fddfd", "fvffe", "dffdfd", "dffd", 1);
        ProductEntity entity2 = new ProductEntity(2, "Cupcake", 120, 12, "fddfd", "fvffe", "dffdfd", "dffd", 1);

        products.add(entity1);
        products.add(entity2);

        OrderEntity order = new OrderEntity(1,"Alice","Green","alice@gmail.com","0994746593", products);

        List<OrderEntity> list = new ArrayList<>();
        list.add(order);

        var newlist = orderService.convertToDto(list);

        assertEquals(list.get(0).getName(),newlist.get(0).getName());
    }
}*/