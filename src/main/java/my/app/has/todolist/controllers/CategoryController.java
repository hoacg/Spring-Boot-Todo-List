package my.app.has.todolist.controllers;

import my.app.has.todolist.models.Category;
import my.app.has.todolist.models.Todo;
import my.app.has.todolist.services.ICategoryService;
import my.app.has.todolist.services.ITodoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/categories")
public class CategoryController {

    private ICategoryService categoryService;
    private ITodoService todoService;

    CategoryController(ICategoryService categoryService, ITodoService todoService) {
        this.categoryService = categoryService;
        this.todoService = todoService;
    }


    @GetMapping("")
    ResponseEntity<List<Category>> getList() {
        List<Category> todos = categoryService.getList();
        return new ResponseEntity<>(todos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    ResponseEntity<Category> getDetail(@PathVariable Long id) {
        Optional<Category> category = categoryService.getDetail(id);
        Category res;
        HttpStatus resStatus = HttpStatus.OK;
        if (category.isPresent()) {
            res = category.get();
        } else {
            res = null;
            resStatus = HttpStatus.NOT_FOUND;
        }
        return new ResponseEntity<>(res, resStatus);
    }

    @GetMapping("/{id}/todos")
    ResponseEntity<List<Todo>> getTodoByCategory(@PathVariable Long id) {
        Optional<Category> oCategory = categoryService.getDetail(id);
        Category category;
        List<Todo> todoList = new ArrayList<>();
        HttpStatus resStatus;
        if (oCategory.isPresent()) {
            category = oCategory.get();
            todoList = (List<Todo>) todoService.getTodoByCategory(category);
            resStatus = HttpStatus.OK;
        } else {
            resStatus = HttpStatus.NOT_FOUND;
        }
        return new ResponseEntity<>(todoList, resStatus);
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
