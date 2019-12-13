package my.app.has.products.services;

import my.app.has.MyApplication;
import my.app.has.products.models.Product;
import my.app.has.products.repository.ProductRepository;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MyApplication.class)
class ProductServiceTest {

    @MockBean
    ProductRepository productRepository;

    @MockBean
    IProductService productService;

    @Before
    void init() {
        Product product = new Product();
        product.setName("iPhone X");
        product.setPrice(15000000d);
        product.setDescription("An Apple product");
        when(productRepository.findById(1L)).thenReturn(Optional.of(product));

        List<Product> productList = new ArrayList<>();
        productList.add(product);
        when(productRepository.findAll()).thenReturn(productList);

        productService = new ProductService(productRepository);
    }

    @Test
    void getList() {
        assertThat(productService.getList()).isNotNull();
    }

//    @Test
//    void save() {
//    }
//
//    @Test
//    void delete() {
//    }
}