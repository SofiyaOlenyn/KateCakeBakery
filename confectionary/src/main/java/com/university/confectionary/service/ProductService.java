package com.university.confectionary.service;

import com.university.confectionary.domain.entities.ProductEntity;
import com.university.confectionary.dto.CatalogResponseDto;
import com.university.confectionary.dto.ProductDto;
import com.university.confectionary.repositories.ProductRepository;
import com.university.confectionary.repositories.ProductTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductTypeRepository productTypeRepository;


    @Transactional
    public ResponseEntity<CatalogResponseDto> getProductByType(String type) {
        var catalog = new CatalogResponseDto();
        var products = productRepository.findProductEntitiesByProductTypeEntityType(type);
        var productsDtoList = new ArrayList<ProductDto>();
        for (ProductEntity product: products) {
            productsDtoList.add(new ProductDto(product.getName(), product.getPrice(), product.getWeight(), product.getImageUrl(), product.getId()));
        }

        var productType = productTypeRepository.findProductTypeEntityByType(type);

        catalog.setItems(productsDtoList);
        catalog.setName(productType.getName());
        catalog.setCatalogImagePath(productType.getCatalogImageUrl());
        catalog.setCatalogImageHoverUrl(productType.getCatalogImageHoverUrl());
        catalog.setDetailedText(productType.getDetailedText());
        catalog.setEnumEquivalent(productType.getEnumEquivalent());

        return ResponseEntity
                .status(HttpStatus.OK)
                .header(HttpHeaders.AUTHORIZATION, "generated-jwt-token")
                .body(catalog);
    }

}
