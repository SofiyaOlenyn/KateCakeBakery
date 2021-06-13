package com.university.confectionary.service;

import com.university.confectionary.domain.entities.ProductEntity;
import com.university.confectionary.domain.entities.ProductTypeEntity;
import com.university.confectionary.dto.CatalogResponseDto;
import com.university.confectionary.dto.ProductDetailsDto;
import com.university.confectionary.dto.ProductDto;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;

import java.util.List;

@SpringBootTest
public class ProductServiceTest extends TestCase {

    @Autowired
    public ProductService productService;

    @Test
    public void testGetProductByType() {
        String type = "Cake";
        productService.getProductByType(type);
        ResponseEntity<CatalogResponseDto> products = productService.getProductByType(type);

        var catalog = new CatalogResponseDto();
        catalog = products.getBody();

        assert catalog != null;
        List<ProductDto> items = catalog.getItems();

        for (ProductDto item : items) {
            assertFalse(item.getName().isBlank());
        }
    }

    @Test
    public void testGetProductTypes() {
        var types = productService.getProductTypes();
        assert types != null;
        assertEquals("Cake", types.getBody().get(0).getName());
    }

    @Test
    public void testGetProductDetailsById() {
        var product = productService.getProductDetailsById(1);
        assert product.getBody() != null;
        assertEquals("Strawberry Cake", product.getBody().getName());
    }

    @Test
    public void testCreateProduct() {
       // ProductTypeEntity type = new ProductTypeEntity("Cupcake", "Cupcake", "dffd", "dsff", 1);
        ProductEntity entity = new ProductEntity(2, "Cupcake", 120, 12, "fddfd", "fvffe", "dffdfd", "dffd", 1);
        ProductDetailsDto product = new ProductDetailsDto(entity);
        ProductEntity newProduct = productService.createProduct(product);

        assertEquals(product.getName(),newProduct.getName());
    }

    @Test
    public void testAddProduct() {
        ProductEntity entity = new ProductEntity(2, "Cupcake", 120, 12, "fddfd", "fvffe", "dffdfd", "dffd", 1);
        ProductDetailsDto product = new ProductDetailsDto(entity);
        ProductDetailsDto newProduct = productService.addProduct(product).getBody();

        assert newProduct != null;
        assertEquals(product.getName(),newProduct.getName());
    }

    @Test
    public void testUpdateProduct() {
        ProductDetailsDto product = productService.getProductDetailsById(1).getBody();
        assert product != null;
        product.setName("Cheesecake");

        ProductDetailsDto newProduct = productService.updateProduct(product).getBody();

        assert newProduct != null;
        assertEquals(product.getName(),newProduct.getName());
    }

    @Test
    public void testDeleteProduct() {
        productService.deleteProduct(1);
        var product = productService.getProductDetailsById(1).getBody();
        assert product == null;
    }
}