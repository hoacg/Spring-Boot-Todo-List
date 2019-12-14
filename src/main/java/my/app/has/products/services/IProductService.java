package my.app.has.products.services;

import my.app.has.products.models.Product;
import java.util.List;
import java.util.Optional;

public interface IProductService {
    Optional<Product> findById(Long id);
    List<Product> getList();
    Product save(Product product);
    void delete(Long id);
}
