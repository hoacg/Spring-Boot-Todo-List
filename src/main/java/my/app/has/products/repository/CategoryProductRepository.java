package my.app.has.products.repository;

import my.app.has.products.models.CategoryProduct;
import org.springframework.data.repository.CrudRepository;

public interface CategoryProductRepository extends CrudRepository<CategoryProduct, Long> {
}
