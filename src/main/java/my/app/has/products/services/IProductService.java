package my.app.has.products.services;

import my.app.has.products.models.Product;

public interface IProductService {
    Iterable<Product> getList();
    Product save(Product product);
    void delete(Long id);
}
