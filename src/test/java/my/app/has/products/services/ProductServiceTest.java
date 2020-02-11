package my.app.has.products.services;

import my.app.has.products.models.Product;
import my.app.has.products.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
class ProductServiceTest {

    private ProductRepository productRepository = Mockito.mock(ProductRepository.class);
    private IProductService productService = new ProductService(productRepository);

    @BeforeEach
    void init() {
        Product product = new Product();
        product.setName("iPhone X");
        product.setPrice(15000000d);
        product.setDescription("An Apple product");
        // when(productRepository.findById(1L)).thenReturn(Optional.of(product));
        doReturn(Optional.of(product)).when(productRepository).findById(1L);

        List<Product> productList = Arrays.asList(product);
        // when(productRepository.findAll()).thenReturn(productList);
        doReturn(productList).when(productRepository).findAll();
    }

    @DisplayName("getList() can return list (is not null)")
    @Test
    void whenGetList_thenNotNull() {
        assertThat(productService.getList()).isNotNull();
    }

    @DisplayName("getList() return a list with 1 element")
    @Test
    public void whenFindAll_thenReturnProductList() {
        // when
        List<Product> actualProducts = productService.getList();

        // then
        assertThat(actualProducts).hasSize(1);
    }

    @DisplayName("findById() return a product has name `iPhone X`")
    @Test
    public void whenFindById_thenReturnProduct() {
        // when
        Optional<Product> product = productService.findById(1L);

        // then
        assertThat(product.get().getName()).isEqualTo("iPhone X");
    }

    @DisplayName("Kiểm tra xem hàm getProductNameWithoutSpace trả về có dấu gạch ngang không!")
    @Test
    void testReturlRightUrl() {
        String name = productService.getProductNameWithoutSpace(1L);

        assertThat(name).isEqualTo("iPhone-X");
    }
}