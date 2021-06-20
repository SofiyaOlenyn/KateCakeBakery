// package com.university.confectionary.service;

// import com.university.confectionary.domain.entities.ProductTypeEntity;
// import com.university.confectionary.dto.AssortementDto;
// import com.university.confectionary.dto.CatalogResponseDto;
// <<<<<<< ak-dev
// import com.university.confectionary.repositories.ProductRepository;
// import com.university.confectionary.repositories.ProductTypeRepository;
// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;
// import org.junit.jupiter.api.extension.ExtendWith;
// import org.junit.jupiter.params.ParameterizedTest;
// import org.junit.jupiter.params.provider.Arguments;
// import org.junit.jupiter.params.provider.MethodSource;
// import org.mockito.InjectMocks;
// import org.mockito.Mock;
// import org.mockito.junit.jupiter.MockitoExtension;
// import org.mockito.junit.jupiter.MockitoSettings;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import java.util.ArrayList;
// import java.util.List;
// import java.util.Locale;
// import java.util.stream.Stream;
// import static org.assertj.core.api.Assertions.assertThat;
// import static org.mockito.ArgumentMatchers.anyString;
// import static org.mockito.Mockito.verify;
// import static org.mockito.Mockito.when;

// //package com.university.confectionary.service;
// //
// //import com.university.confectionary.domain.entities.ProductEntity;
// //import com.university.confectionary.domain.entities.ProductTypeEntity;
// //import com.university.confectionary.dto.CatalogResponseDto;
// //import com.university.confectionary.dto.ProductDetailsDto;
// //import com.university.confectionary.dto.ProductDto;
// //import junit.framework.TestCase;
// //import org.junit.After;
// //import org.junit.Before;
// //import org.junit.Test;
// //import org.springframework.beans.factory.annotation.Autowired;
// //import org.springframework.boot.test.context.SpringBootTest;
// //import org.springframework.boot.test.mock.mockito.SpyBean;
// //import org.springframework.http.ResponseEntity;
// //
// //
// //import java.util.List;
// //
// //@SpringBootTest
// //public class ProductServiceTest extends TestCase {
// //
// //    @Autowired
// //    public ProductService productService;
// //
// //    @Test
// //    public void testGetProductByType() {
// //        String type = "Cake";
// //        productService.getProductByType(type);
// //        ResponseEntity<CatalogResponseDto> products = productService.getProductByType(type);
// //
// //        var catalog = new CatalogResponseDto();
// //        catalog = products.getBody();
// //
// //        assert catalog != null;
// //        List<ProductDto> items = catalog.getItems();
// //
// //        for (ProductDto item : items) {
// //            assertFalse(item.getName().isBlank());
// //        }
// //    }
// //
// //    @Test
// //    public void testGetProductTypes() {
// //        var types = productService.getProductTypes();
// //        assert types != null;
// //        assertEquals("Cake", types.getBody().get(0).getName());
// //    }
// //
// //    @Test
// //    public void testGetProductDetailsById() {
// //        var product = productService.getProductDetailsById(1);
// //        assert product.getBody() != null;
// //        assertEquals("Strawberry Cake", product.getBody().getName());
// //    }
// //
// //    @Test
// //    public void testCreateProduct() {
// //       // ProductTypeEntity type = new ProductTypeEntity("Cupcake", "Cupcake", "dffd", "dsff", 1);
// //        ProductEntity entity = new ProductEntity(2, "Cupcake", 120, 12, "fddfd", "fvffe", "dffdfd", "dffd", 1);
// //        ProductDetailsDto product = new ProductDetailsDto(entity);
// //        ProductEntity newProduct = productService.createProduct(product);
// //
// //        assertEquals(product.getName(),newProduct.getName());
// //    }
// //
// //    @Test
// //    public void testAddProduct() {
// //        ProductEntity entity = new ProductEntity(2, "Cupcake", 120, 12, "fddfd", "fvffe", "dffdfd", "dffd", 1);
// //        ProductDetailsDto product = new ProductDetailsDto(entity);
// //        ProductDetailsDto newProduct = productService.addProduct(product).getBody();
// //
// //        assert newProduct != null;
// //        assertEquals(product.getName(),newProduct.getName());
// //    }
// //
// //    @Test
// //    public void testUpdateProduct() {
// //        ProductDetailsDto product = productService.getProductDetailsById(1).getBody();
// //        assert product != null;
// //        product.setName("Cheesecake");
// //
// //        ProductDetailsDto newProduct = productService.updateProduct(product).getBody();
// //
// //        assert newProduct != null;
// //        assertEquals(product.getName(),newProduct.getName());
// //    }
// //
// //    @Test
// //    public void testDeleteProduct() {
// //        productService.deleteProduct(1);
// //        var product = productService.getProductDetailsById(1).getBody();
// //        assert product == null;
// //    }
// //}
// @ExtendWith(MockitoExtension.class)
// public class ProductServiceTest {

//     @Mock
//     private ProductRepository productRepository;
// =======
// import com.university.confectionary.dto.ProductDetailsDto;
// import com.university.confectionary.dto.ProductDto;
// import com.university.confectionary.repositories.ProductRepository;
// import com.university.confectionary.repositories.ProductTypeRepository;
// import junit.framework.TestCase;
// import org.junit.After;
// import org.junit.Before;
// import org.junit.Test;
// import org.junit.runner.RunWith;
// import org.mockito.InjectMocks;
// import org.mockito.Mock;
// import org.mockito.runners.MockitoJUnitRunner;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.boot.test.mock.mockito.SpyBean;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.security.core.parameters.P;

// import java.util.ArrayList;
// import java.util.List;
// import java.util.Optional;

// import static org.mockito.BDDMockito.given;
// import static org.mockito.Matchers.anyString;
// import static org.mockito.Mockito.*;

// //@SpringBootTest
// @RunWith(MockitoJUnitRunner.class )
// public class ProductServiceTest extends TestCase {

//     @Mock
//     private ProductRepository productRepository;

// >>>>>>> main
//     @Mock
//     private ProductTypeRepository productTypeRepository;

//     @InjectMocks
// <<<<<<< ak-dev
//     private ProductService productService;

//     @BeforeEach
//     void init() {
//         ProductTypeEntity productTypeEntity1 = new ProductTypeEntity(1,"cakes", "Тортіки", "https://dkupchyk.github.io/KateCake-Bakery/assets/images/main/assortment-cakes.png","https://dkupchyk.github.io/KateCake-Bakery/assets/images/main/assortment-cakes-overlay.png","Является текст-заполнитель обычно используется в графических, печать и издательской индустрии для предварительного просмотра макета и визуальных макетах.",0,new ArrayList<>());
//         when(productTypeRepository.findProductTypeEntityByType(anyString())).thenReturn(productTypeEntity1);
// //        Mockito.lenient()
//     }

//     @Test
//     void getProductByTypeTest() {
//         String type = "cakes";

//         ResponseEntity<CatalogResponseDto> responseDtoResponseEntity =productService.getProductByType(type);
//         responseDtoResponseEntity.getStatusCode().equals(HttpStatus.FOUND);
//         assertThat(responseDtoResponseEntity.getBody()).isEqualTo(
//                 CatalogResponseDto.builder()
//                         .name("Тортіки")
//                         .catalogImagePath("https://dkupchyk.github.io/KateCake-Bakery/assets/images/main/assortment-cakes.png")
//                         .catalogImageHoverUrl("https://dkupchyk.github.io/KateCake-Bakery/assets/images/main/assortment-cakes-overlay.png")
//                         .detailedText("Является текст-заполнитель обычно используется в графических, печать и издательской индустрии для предварительного просмотра макета и визуальных макетах.")
//                         .enumEquivalent(0)
//                         .items(new ArrayList<>())
//                         .build()
//         );

//         verify(productRepository).findProductEntitiesByProductTypeEntityType(type);
//         verify(productTypeRepository).findProductTypeEntityByType(type);
//     }


// }
// =======
//     public ProductService productService =new ProductService(productRepository,productTypeRepository);

//     @Before
//     public void setUp(){
//         ProductTypeEntity productTypeEntity = new ProductTypeEntity(1,"Cake","Cakesss","dscdsc","dsffdfd","dscf",1, new ArrayList<ProductEntity>());
//         when(productTypeRepository.findProductTypeEntityByType(anyString())).thenReturn(productTypeEntity);

//         productService = new ProductService(productRepository,productTypeRepository);
//     }

//     @Test
//     public void testGetProductByType() {
//         String type = "Cake";

//         ResponseEntity<CatalogResponseDto> responseDtoResponseEntity = productService.getProductByType(type);
//         responseDtoResponseEntity.getStatusCode().equals(HttpStatus.FOUND);

//         CatalogResponseDto catalogResponseDto = new CatalogResponseDto("Cakesss","dscdsc","dsffdfd","dscf",1,new ArrayList<>());
//         assertEquals(responseDtoResponseEntity.getBody(),
//                 catalogResponseDto );

//         verify(productRepository).findProductEntitiesByProductTypeEntityType(type);
//         verify(productTypeRepository).findProductTypeEntityByType(type);
//     }

//     @Test
//     public void testGetProductTypes() {
//         ProductTypeEntity productTypeEntity = new ProductTypeEntity(1,"Cake","Cakesss","dscdsc","dsffdfd","dscf",1, new ArrayList<ProductEntity>());

//         List<ProductTypeEntity> list = new ArrayList<>();
//         list.add(productTypeEntity);

//         when(productTypeRepository.findAll()).thenReturn(list);

//         ResponseEntity<List<AssortementDto>> response = productService.getProductTypes();
//         response.getStatusCode().equals(HttpStatus.FOUND);

//         List<AssortementDto> assortementDto = new ArrayList<>();
//         AssortementDto assortementDto1 = new AssortementDto("Cakesss","dscdsc","dsffdfd","dscf",1);
//         assortementDto.add(assortementDto1);

//         assertEquals(response.getBody(),
//                 assortementDto );
//     }

//     @Test
//     public void testGetProductDetailsById() {
//         ProductTypeEntity productTypeEntity = new ProductTypeEntity(1,"Cake","dsfdd","dscdsc","dsffdfd","dscf",1, new ArrayList<ProductEntity>());
//         ProductEntity productEntity = new ProductEntity(0,"dsfdd",0,0,"dsfdd","dsfdd","dsfdd",new ProductTypeEntity(), new ArrayList<>());

//         when(productRepository.findProductEntityById(0)).thenReturn(java.util.Optional.of(productEntity));

//         ResponseEntity<ProductDetailsDto> responseEntity = productService.getProductDetailsById(0);

//         responseEntity.getStatusCode().equals(HttpStatus.FOUND);

//         ProductDetailsDto productDetailsDto = new ProductDetailsDto("dsfdd",0,0,"dsfdd","dsfdd","dsfdd",0,null);
//         assertEquals(responseEntity.getBody(),
//                 productDetailsDto );

//     }

//     @Test
//     public void testCreateProduct() {
//         ProductTypeEntity productTypeEntity = new ProductTypeEntity(1,"Cake","dsfdd","dscdsc","dsffdfd","dscf",1, new ArrayList<ProductEntity>());

//         ProductEntity productEntity = new ProductEntity(0,"dsfdd",0,0,"dsfdd","dsfdd","dsfdd",productTypeEntity, new ArrayList<>());
//         ProductDetailsDto productDetailsDto = new ProductDetailsDto(productEntity);

//         given(productRepository.findProductEntityById(0)).willReturn(Optional.empty());
//         given(productRepository.save(productEntity)).willAnswer(invocation -> invocation.getArguments()[1]);


//        ProductEntity saved =  productService.createProduct(productDetailsDto);

//         verify(productTypeRepository).findProductTypeEntityByType("Cake");

//     }

//     @Test
//     public void testAddProduct() {
//         ProductTypeEntity productTypeEntity = new ProductTypeEntity(1,"Cake","dsfdd","dscdsc","dsffdfd","dscf",1, new ArrayList<>());

//         ProductEntity productEntity = new ProductEntity(0,"dsfdd",0,0,"dsfdd","dsfdd","dsfdd",productTypeEntity, new ArrayList<>());
//         ProductDetailsDto productDetailsDto = new ProductDetailsDto(productEntity);

//         given(productRepository.findProductEntityById(0)).willReturn(Optional.empty());
//         given(productRepository.save(productEntity)).willAnswer(invocation -> invocation.getArguments()[1]);

//         ProductEntity saved =  productService.createProduct(productDetailsDto);

//         verify(productTypeRepository).findProductTypeEntityByType("Cake");

//     }

//     @Test
//     public void testUpdateProduct() {
//         ProductTypeEntity productTypeEntity = new ProductTypeEntity(1,"Cake","dsfdd","dscdsc","dsffdfd","dscf",1, new ArrayList<ProductEntity>());

//         ProductDetailsDto productDetailsDto = new ProductDetailsDto("dsfdd",0,0,"dsfdd","dsfdd","dsfdd",0,"Cake");
//         ProductEntity productEntity = new ProductEntity(0,"dsfdd",0,0,"dsfdd","dsfdd","dsfdd",productTypeEntity, new ArrayList<>());

//         given(productRepository.save(productEntity)).willReturn(productEntity);
//         when(productRepository.findProductEntityById(productDetailsDto.getId())).thenReturn(Optional.of(productEntity));


//         ResponseEntity expected = productService.updateProduct(productDetailsDto);

//         verify(productTypeRepository).findProductTypeEntityByType("Cake");
//     }

//     @Test
//     public void testDeleteProduct() {
//         productService.deleteProduct(1);
//         verify(productRepository,times(1)).deleteById(1);
//     }
// }*/
// >>>>>>> main
