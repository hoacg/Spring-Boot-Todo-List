package my.app.has.products.controllers;

import my.app.has.products.models.HttpResult;
import my.app.has.products.models.Product;
import my.app.has.products.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
public class ProductController {

    final private IProductService productService;

    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/api/products")
    public ResponseEntity<HttpResult<List<Product>>> getList() {
        List<Product> productList = productService.getList();

        HttpResult<List<Product>> res = new HttpResult<>();
        res.setSuccess(true);
        res.setMessage("ok");
        res.setData(productList);

        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @PostMapping("/api/products")
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        Product savedProduct = productService.save(product);
        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
    }

    @DeleteMapping("/api/products/{id}")
    public ResponseEntity<HttpResult<Void>> deleteProduct(@PathVariable Long id) {
        HttpResult<Void> res = new HttpResult<>();

        try {
            productService.delete(id);

            res.setSuccess(true);
            res.setMessage("Xoá thành công!");

        } catch (Exception ex) {
            res.setSuccess(false);
            res.setMessage(ex.getMessage());
        }
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}
