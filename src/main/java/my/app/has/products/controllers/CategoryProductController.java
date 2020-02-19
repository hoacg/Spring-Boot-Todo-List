package my.app.has.products.controllers;

import my.app.has.products.services.ICategoryProductService;
import my.app.has.products.models.CategoryProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
public class CategoryProductController {

    @Autowired
    private ICategoryProductService categoryService;

    @GetMapping("/api/category")
    public ResponseEntity<Iterable<CategoryProduct>> findAll() {
        Iterable<CategoryProduct> categories = this.categoryService.getCategories();

        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @PostMapping("/api/category")
    public ResponseEntity<CategoryProduct> addCategory(@RequestBody CategoryProduct categoryProduct) {
        CategoryProduct category = this.categoryService.addCategory(categoryProduct);

        return new ResponseEntity<>(category, HttpStatus.OK);
    }
}
