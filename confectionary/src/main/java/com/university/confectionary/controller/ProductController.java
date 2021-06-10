package com.university.confectionary.controller;

import com.university.confectionary.domain.entities.OrderEntity;
import com.university.confectionary.dto.AssortementDto;
import com.university.confectionary.dto.CatalogResponseDto;
import com.university.confectionary.dto.OrderDto;
import com.university.confectionary.dto.ProductDetailsDto;
import com.university.confectionary.service.NotificationService;
import com.university.confectionary.service.OrderService;
import com.university.confectionary.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    private final OrderService orderService;
    private final NotificationService notificationService;
    private Logger logger = LoggerFactory.getLogger(ProductController.class);

    // get products of specified type by catalog/cakes endpoint
    @RequestMapping(value = "/catalog/{productType}", method = RequestMethod.GET)
    public ResponseEntity<CatalogResponseDto> catalog(
            @PathVariable final String productType
    ) {
        return productService.getProductByType(productType);
    }

    // get all assortment(types) by /catalog endpoint
    @RequestMapping(value = "/catalog", method = RequestMethod.GET)
    public ResponseEntity<List<AssortementDto>> catalog() {
        return productService.getProductTypes();
    }

    //get detailed info about product by /product/1 endpoint
    @RequestMapping(value = "/product/{productId}", method = RequestMethod.GET)
    public ResponseEntity<ProductDetailsDto> product(
            @PathVariable final Integer productId
    ) {
        return productService.getProductDetailsById(productId);
    }

    //create order by /order endpoint
    @RequestMapping(value = "/order", method = RequestMethod.POST)
    public ResponseEntity<String> product(
            @RequestBody final OrderDto orderDto) {
        ResponseEntity<String> result = orderService.createOrder(orderDto);
        try{
            notificationService.sendEmail(orderDto);
        }catch (MailException e){
            logger.info("Error: "+e.getMessage() );
        }
        return result;
    }
}