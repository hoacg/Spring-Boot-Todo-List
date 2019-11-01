package my.app.has.todolist.controllers;

import my.app.has.todolist.models.Category;
import my.app.has.todolist.models.Tag;
import my.app.has.todolist.models.Todo;
import my.app.has.todolist.services.ICategoryService;
import my.app.has.todolist.services.ITagService;
import my.app.has.todolist.services.ITodoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/tags")
public class TagController {

    private ITagService tagService;
    private ITodoService todoService;

    TagController(ITagService tagService, ITodoService todoService) {
        this.tagService = tagService;
        this.todoService = todoService;
    }


    @GetMapping("")
    ResponseEntity<List<Tag>> getList() {
        List<Tag> todos = tagService.getList();
        return new ResponseEntity<>(todos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    ResponseEntity<Tag> getDetail(@PathVariable Long id) {
        Optional<Tag> category = tagService.getDetail(id);
        Tag res;
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
    ResponseEntity<Tag> add(@RequestBody Tag category) {
        Tag insertedCategory = tagService.save(category);
        return new ResponseEntity<>(insertedCategory, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    ResponseEntity<Tag> update(@PathVariable Long id, @RequestBody Tag category) {
        Tag insertedTag = tagService.updateById(id, category);
        return new ResponseEntity<>(insertedTag, HttpStatus.OK);
    }
}
