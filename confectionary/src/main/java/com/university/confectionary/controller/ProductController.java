package com.university.confectionary.controller;

import com.university.confectionary.dto.CatalogResponseDto;
import com.university.confectionary.service.ProductService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @RequestMapping(value = "/catalog/{productType}", method = RequestMethod.GET)
    public ResponseEntity<CatalogResponseDto> catalog(
            @PathVariable final String productType
    ) {
        return productService.getProductByType(productType);
    }
}