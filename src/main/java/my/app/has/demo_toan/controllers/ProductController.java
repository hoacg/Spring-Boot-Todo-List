package my.app.has.demo_toan.controllers;

import my.app.has.demo_toan.models.Product;
import my.app.has.demo_toan.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
public class ProductController {

    @Autowired
    private IProductService productService;

    @GetMapping("/api/products")
    public ResponseEntity<List<Product>> getList() {
        List<Product> productList = (List<Product>) productService.getList();
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }

    @PostMapping("/api/products")
    public ResponseEntity<Void> addProduct(@RequestBody Product product) {
        productService.save(product);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/api/products/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
