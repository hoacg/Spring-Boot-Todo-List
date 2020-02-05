package my.app.has.products.services;

import my.app.has.products.models.Product;
import my.app.has.products.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService {
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public String getProductNameWithoutSpace(Long id) {
        Optional<Product> product = productRepository.findById(id);

        if (product.isPresent()) {
            return product.get().getName().replace(' ', '-');
        }
        return "";
    }


    @Override
    public List<Product> getList() {
        return productRepository.findAll();
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void delete(Long id) throws Exception {
        Optional<Product> product = productRepository.findById(id);

        if (!product.isPresent()) {
            throw new Exception("Sản phẩm này không tồn tại.");
        } else if (!product.get().isCanDelete()) {
            throw new Exception("Sản phẩm này không được xoá.");
        } else {
            productRepository.deleteById(id);
        }
    }
}
