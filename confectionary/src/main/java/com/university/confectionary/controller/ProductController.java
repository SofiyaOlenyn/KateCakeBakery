package com.university.confectionary.controller;

import com.university.confectionary.dto.AssortementDto;
import com.university.confectionary.dto.CatalogResponseDto;
import com.university.confectionary.service.ProductService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    // catalog/cakes endpoint
    @RequestMapping(value = "/catalog/{productType}", method = RequestMethod.GET)
    public ResponseEntity<CatalogResponseDto> catalog(
            @PathVariable final String productType
    ) {
        return productService.getProductByType(productType);
    }

    // get all assortment(types)
    @RequestMapping(value = "/catalog", method = RequestMethod.GET)
    public ResponseEntity<List<AssortementDto>> catalog() {
        return productService.getProductTypes();
    }

}