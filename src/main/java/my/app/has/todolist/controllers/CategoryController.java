package my.app.has.todolist.controllers;

import my.app.has.todolist.models.Category;
import my.app.has.todolist.services.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    ICategoryService categoryService;

    @GetMapping("")
    ResponseEntity<List<Category>> getList() {
        List<Category> todos = (List<Category>) categoryService.getList();
        return new ResponseEntity<>(todos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    ResponseEntity<Category> getDetail(@PathVariable Long id) {
        Optional<Category> category = categoryService.getDetail(id);
        Category res;
        HttpStatus resStatus;
        if (category.isPresent()) {
            res = category.get();
            resStatus = HttpStatus.OK;
        } else {
            res = null;
            resStatus = HttpStatus.NOT_FOUND;
        }
        return new ResponseEntity<>(res, resStatus);
    }

    @PostMapping(value = "")
    ResponseEntity<Category> add(@RequestBody Category category) {
        Category insertedCategory = categoryService.save(category);
        return new ResponseEntity<>(insertedCategory, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    ResponseEntity<Category> update(@PathVariable Long id, @RequestBody Category category) {
        Category insertedCategory = categoryService.updateById(id, category);
        return new ResponseEntity<>(insertedCategory, HttpStatus.OK);
    }
}