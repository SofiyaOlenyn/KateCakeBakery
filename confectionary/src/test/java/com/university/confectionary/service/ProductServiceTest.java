package com.university.confectionary.service;

import com.university.confectionary.domain.entities.ProductTypeEntity;
import com.university.confectionary.dto.CatalogResponseDto;
import com.university.confectionary.repositories.ProductRepository;
import com.university.confectionary.repositories.ProductTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Stream;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

//package com.university.confectionary.service;
//
//import com.university.confectionary.domain.entities.ProductEntity;
//import com.university.confectionary.domain.entities.ProductTypeEntity;
//import com.university.confectionary.dto.CatalogResponseDto;
//import com.university.confectionary.dto.ProductDetailsDto;
//import com.university.confectionary.dto.ProductDto;
//import junit.framework.TestCase;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.SpyBean;
//import org.springframework.http.ResponseEntity;
//
//
//import java.util.List;
//
//@SpringBootTest
//public class ProductServiceTest extends TestCase {
//
//    @Autowired
//    public ProductService productService;
//
//    @Test
//    public void testGetProductByType() {
//        String type = "Cake";
//        productService.getProductByType(type);
//        ResponseEntity<CatalogResponseDto> products = productService.getProductByType(type);
//
//        var catalog = new CatalogResponseDto();
//        catalog = products.getBody();
//
//        assert catalog != null;
//        List<ProductDto> items = catalog.getItems();
//
//        for (ProductDto item : items) {
//            assertFalse(item.getName().isBlank());
//        }
//    }
//
//    @Test
//    public void testGetProductTypes() {
//        var types = productService.getProductTypes();
//        assert types != null;
//        assertEquals("Cake", types.getBody().get(0).getName());
//    }
//
//    @Test
//    public void testGetProductDetailsById() {
//        var product = productService.getProductDetailsById(1);
//        assert product.getBody() != null;
//        assertEquals("Strawberry Cake", product.getBody().getName());
//    }
//
//    @Test
//    public void testCreateProduct() {
//       // ProductTypeEntity type = new ProductTypeEntity("Cupcake", "Cupcake", "dffd", "dsff", 1);
//        ProductEntity entity = new ProductEntity(2, "Cupcake", 120, 12, "fddfd", "fvffe", "dffdfd", "dffd", 1);
//        ProductDetailsDto product = new ProductDetailsDto(entity);
//        ProductEntity newProduct = productService.createProduct(product);
//
//        assertEquals(product.getName(),newProduct.getName());
//    }
//
//    @Test
//    public void testAddProduct() {
//        ProductEntity entity = new ProductEntity(2, "Cupcake", 120, 12, "fddfd", "fvffe", "dffdfd", "dffd", 1);
//        ProductDetailsDto product = new ProductDetailsDto(entity);
//        ProductDetailsDto newProduct = productService.addProduct(product).getBody();
//
//        assert newProduct != null;
//        assertEquals(product.getName(),newProduct.getName());
//    }
//
//    @Test
//    public void testUpdateProduct() {
//        ProductDetailsDto product = productService.getProductDetailsById(1).getBody();
//        assert product != null;
//        product.setName("Cheesecake");
//
//        ProductDetailsDto newProduct = productService.updateProduct(product).getBody();
//
//        assert newProduct != null;
//        assertEquals(product.getName(),newProduct.getName());
//    }
//
//    @Test
//    public void testDeleteProduct() {
//        productService.deleteProduct(1);
//        var product = productService.getProductDetailsById(1).getBody();
//        assert product == null;
//    }
//}
@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;
    @Mock
    private ProductTypeRepository productTypeRepository;

    @InjectMocks
    private ProductService productService;

    @BeforeEach
    void init() {
        ProductTypeEntity productTypeEntity1 = new ProductTypeEntity(1,"cakes", "Тортіки", "https://dkupchyk.github.io/KateCake-Bakery/assets/images/main/assortment-cakes.png","https://dkupchyk.github.io/KateCake-Bakery/assets/images/main/assortment-cakes-overlay.png","Является текст-заполнитель обычно используется в графических, печать и издательской индустрии для предварительного просмотра макета и визуальных макетах.",0,new ArrayList<>());
        when(productTypeRepository.findProductTypeEntityByType(anyString())).thenReturn(productTypeEntity1);
//        Mockito.lenient()
    }

    @Test
    void getProductByTypeTest() {
        String type = "cakes";

        ResponseEntity<CatalogResponseDto> responseDtoResponseEntity =productService.getProductByType(type);
        responseDtoResponseEntity.getStatusCode().equals(HttpStatus.FOUND);
        assertThat(responseDtoResponseEntity.getBody()).isEqualTo(
                CatalogResponseDto.builder()
                        .name("Тортіки")
                        .catalogImagePath("https://dkupchyk.github.io/KateCake-Bakery/assets/images/main/assortment-cakes.png")
                        .catalogImageHoverUrl("https://dkupchyk.github.io/KateCake-Bakery/assets/images/main/assortment-cakes-overlay.png")
                        .detailedText("Является текст-заполнитель обычно используется в графических, печать и издательской индустрии для предварительного просмотра макета и визуальных макетах.")
                        .enumEquivalent(0)
                        .items(new ArrayList<>())
                        .build()
        );

        verify(productRepository).findProductEntitiesByProductTypeEntityType(type);
        verify(productTypeRepository).findProductTypeEntityByType(type);
    }


}