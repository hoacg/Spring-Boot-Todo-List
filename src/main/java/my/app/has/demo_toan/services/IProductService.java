package my.app.has.demo_toan.services;

import my.app.has.demo_toan.models.Product;

public interface IProductService {
    Iterable<Product> getList();
    Product save(Product product);
    void delete(Long id);
}
