package my.app.has.demo_toan.repository;

import my.app.has.demo_toan.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
