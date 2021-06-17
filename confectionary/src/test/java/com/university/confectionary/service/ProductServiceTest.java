/*package com.university.confectionary.service;

import com.university.confectionary.domain.entities.ProductEntity;
import com.university.confectionary.domain.entities.ProductTypeEntity;
import com.university.confectionary.dto.AssortementDto;
import com.university.confectionary.dto.CatalogResponseDto;
import com.university.confectionary.dto.ProductDetailsDto;
import com.university.confectionary.dto.ProductDto;
import com.university.confectionary.repositories.ProductRepository;
import com.university.confectionary.repositories.ProductTypeRepository;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

//@SpringBootTest
@RunWith(MockitoJUnitRunner.class )
public class ProductServiceTest extends TestCase {

    @Mock
    private ProductRepository productRepository;

    @Mock
    private ProductTypeRepository productTypeRepository;

    @InjectMocks
    public ProductService productService =new ProductService(productRepository,productTypeRepository);

    @Before
    public void setUp(){
        ProductTypeEntity productTypeEntity = new ProductTypeEntity(1,"Cake","Cakesss","dscdsc","dsffdfd","dscf",1, new ArrayList<ProductEntity>());
        when(productTypeRepository.findProductTypeEntityByType(anyString())).thenReturn(productTypeEntity);

        productService = new ProductService(productRepository,productTypeRepository);
    }

    @Test
    public void testGetProductByType() {
        String type = "Cake";

        ResponseEntity<CatalogResponseDto> responseDtoResponseEntity = productService.getProductByType(type);
        responseDtoResponseEntity.getStatusCode().equals(HttpStatus.FOUND);

        CatalogResponseDto catalogResponseDto = new CatalogResponseDto("Cakesss","dscdsc","dsffdfd","dscf",1,new ArrayList<>());
        assertEquals(responseDtoResponseEntity.getBody(),
                catalogResponseDto );

        verify(productRepository).findProductEntitiesByProductTypeEntityType(type);
        verify(productTypeRepository).findProductTypeEntityByType(type);
    }

    @Test
    public void testGetProductTypes() {
        ProductTypeEntity productTypeEntity = new ProductTypeEntity(1,"Cake","Cakesss","dscdsc","dsffdfd","dscf",1, new ArrayList<ProductEntity>());

        List<ProductTypeEntity> list = new ArrayList<>();
        list.add(productTypeEntity);

        when(productTypeRepository.findAll()).thenReturn(list);

        ResponseEntity<List<AssortementDto>> response = productService.getProductTypes();
        response.getStatusCode().equals(HttpStatus.FOUND);

        List<AssortementDto> assortementDto = new ArrayList<>();
        AssortementDto assortementDto1 = new AssortementDto("Cakesss","dscdsc","dsffdfd","dscf",1);
        assortementDto.add(assortementDto1);

        assertEquals(response.getBody(),
                assortementDto );
    }

    @Test
    public void testGetProductDetailsById() {
        ProductTypeEntity productTypeEntity = new ProductTypeEntity(1,"Cake","dsfdd","dscdsc","dsffdfd","dscf",1, new ArrayList<ProductEntity>());
        ProductEntity productEntity = new ProductEntity(0,"dsfdd",0,0,"dsfdd","dsfdd","dsfdd",new ProductTypeEntity(), new ArrayList<>());

        when(productRepository.findProductEntityById(0)).thenReturn(java.util.Optional.of(productEntity));

        ResponseEntity<ProductDetailsDto> responseEntity = productService.getProductDetailsById(0);

        responseEntity.getStatusCode().equals(HttpStatus.FOUND);

        ProductDetailsDto productDetailsDto = new ProductDetailsDto("dsfdd",0,0,"dsfdd","dsfdd","dsfdd",0,null);
        assertEquals(responseEntity.getBody(),
                productDetailsDto );

    }

    @Test
    public void testCreateProduct() {
        ProductTypeEntity productTypeEntity = new ProductTypeEntity(1,"Cake","dsfdd","dscdsc","dsffdfd","dscf",1, new ArrayList<ProductEntity>());

        ProductEntity productEntity = new ProductEntity(0,"dsfdd",0,0,"dsfdd","dsfdd","dsfdd",productTypeEntity, new ArrayList<>());
        ProductDetailsDto productDetailsDto = new ProductDetailsDto(productEntity);

        given(productRepository.findProductEntityById(0)).willReturn(Optional.empty());
        given(productRepository.save(productEntity)).willAnswer(invocation -> invocation.getArguments()[1]);


       ProductEntity saved =  productService.createProduct(productDetailsDto);

        verify(productTypeRepository).findProductTypeEntityByType("Cake");

    }

    @Test
    public void testAddProduct() {
        ProductTypeEntity productTypeEntity = new ProductTypeEntity(1,"Cake","dsfdd","dscdsc","dsffdfd","dscf",1, new ArrayList<>());

        ProductEntity productEntity = new ProductEntity(0,"dsfdd",0,0,"dsfdd","dsfdd","dsfdd",productTypeEntity, new ArrayList<>());
        ProductDetailsDto productDetailsDto = new ProductDetailsDto(productEntity);

        given(productRepository.findProductEntityById(0)).willReturn(Optional.empty());
        given(productRepository.save(productEntity)).willAnswer(invocation -> invocation.getArguments()[1]);

        ProductEntity saved =  productService.createProduct(productDetailsDto);

        verify(productTypeRepository).findProductTypeEntityByType("Cake");

    }

    @Test
    public void testUpdateProduct() {
        ProductTypeEntity productTypeEntity = new ProductTypeEntity(1,"Cake","dsfdd","dscdsc","dsffdfd","dscf",1, new ArrayList<ProductEntity>());

        ProductDetailsDto productDetailsDto = new ProductDetailsDto("dsfdd",0,0,"dsfdd","dsfdd","dsfdd",0,"Cake");
        ProductEntity productEntity = new ProductEntity(0,"dsfdd",0,0,"dsfdd","dsfdd","dsfdd",productTypeEntity, new ArrayList<>());

        given(productRepository.save(productEntity)).willReturn(productEntity);
        when(productRepository.findProductEntityById(productDetailsDto.getId())).thenReturn(Optional.of(productEntity));


        ResponseEntity expected = productService.updateProduct(productDetailsDto);

        verify(productTypeRepository).findProductTypeEntityByType("Cake");
    }

    @Test
    public void testDeleteProduct() {
        productService.deleteProduct(1);
        verify(productRepository,times(1)).deleteById(1);
    }
}*/