package com.university.confectionary.service;

import com.university.confectionary.domain.entities.ProductEntity;
import com.university.confectionary.domain.entities.ProductTypeEntity;
import com.university.confectionary.dto.AssortementDto;
import com.university.confectionary.dto.CatalogResponseDto;
import com.university.confectionary.dto.ProductDetailsDto;
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
import java.util.List;

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

    @Transactional
    public ResponseEntity<List<AssortementDto>>  getProductTypes() {
        var catalogs = productTypeRepository.findAll();

        var assortementDtoList = new ArrayList<AssortementDto>();

        for (ProductTypeEntity productType: catalogs) {
            assortementDtoList.add(new AssortementDto(productType.getName(), productType.getCatalogImageUrl(), productType.getCatalogImageHoverUrl(), productType.getDetailedText(), productType.getEnumEquivalent()));
        }

        return ResponseEntity
                .status(HttpStatus.OK)
                .header(HttpHeaders.AUTHORIZATION, "generated-jwt-token")
                .body(assortementDtoList);
    }

    @Transactional
    public ResponseEntity<ProductDetailsDto> getProductDetailsById(Integer id) {
        var product = productRepository.findProductEntityById(id).orElseThrow();

        return ResponseEntity
                .status(HttpStatus.OK)
                .header(HttpHeaders.AUTHORIZATION, "generated-jwt-token")
                .body(new ProductDetailsDto(product.getName(),product.getPrice(),product.getWeight(),product.getImageUrl(),product.getSupplements(), product.getIngredients(), product.getId(), product.getProductTypeEntity().getType()));
    }
}
