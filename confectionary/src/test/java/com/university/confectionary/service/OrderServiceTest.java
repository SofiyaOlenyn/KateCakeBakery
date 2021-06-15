package com.university.confectionary.service;

import com.university.confectionary.domain.entities.OrderEntity;
import com.university.confectionary.domain.entities.ProductEntity;
import com.university.confectionary.domain.entities.ProductTypeEntity;
import com.university.confectionary.dto.OrderDto;
import com.university.confectionary.dto.ProductDetailsDto;
import com.university.confectionary.dto.ProductOrderDto;
import com.university.confectionary.repositories.OrderRepository;
import com.university.confectionary.repositories.ProductRepository;
import junit.framework.TestCase;
import org.aspectj.weaver.ast.Or;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


//@ContextConfiguration(classes = TestConfig.class)
//@SpringBootTest
@RunWith(MockitoJUnitRunner.class )
public class OrderServiceTest {

    @Mock
    private ProductRepository productRepository;

    @Mock
    private OrderRepository orderRepository;

    @SuppressWarnings("SpringJavaAutowiringInspection")
    //@Autowired
   // @InjectMocks
    @InjectMocks
    public OrderService orderService = new OrderService(productRepository,orderRepository);

    @Before
    public void setUp(){

       // orderService = new OrderService(productRepository,orderRepository);
       // reviewsService = new ReviewsService(reviewsRepository);
        // MockitoAnnotations.initMocks(this);

    }

    @Test
    public void testCreateOrder() {

        List<ProductOrderDto> products = new ArrayList<>();
        products.add(new ProductOrderDto(1));
        products.add(new ProductOrderDto(2));

        OrderDto order = new OrderDto("Alice","Green","alice@gmail.com","0994746593", products);

        OrderEntity orderEntity = new OrderEntity();

        //List<ProductEntity> productEntity = convertToEntity(order.getProducts());

      //  OrderEntity orderEntity = new OrderEntity();

//        OrderEntity orderEntity = OrderEntity.builder()
//                .name(order.getName())
//                .surname(order.getSurname())
//                .email(order.getEmail())
//                .phone(order.getPhone())
//                .productList(productEntity)
//                .build();
        ProductTypeEntity productTypeEntity = new ProductTypeEntity(1,"Cake","dsfdd","dscdsc","dsffdfd","dscf",1, new ArrayList<ProductEntity>());

        ProductEntity productEntity = new ProductEntity(0,"dsfdd",0,0,"dsfdd","dsfdd","dsfdd",productTypeEntity, new ArrayList<>());

        when(orderRepository.save(orderEntity)).thenReturn(orderEntity);
      //  when(productRepository.findProductEntityById(products.get(any()).getId()).get()).thenReturn(productEntity);

      //  given(orderRepository.save(orderEntity)).willAnswer(invocation -> invocation.getArgument(0));

      //  OrderEntity created = orderRepository.save(orderEntity);

       // assert(!created.equals(null));

        ResponseEntity<String> response = orderService.createOrder(order);


      //  verify(orderRepository).save(orderEntity);
        //verify(orderRepository).save(any(OrderEntity.class));
      //  assertEquals("Order is created successfully",response);
    }
}