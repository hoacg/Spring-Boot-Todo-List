package my.app.has.todolist.controllers;

import my.app.has.todolist.models.Tag;
import my.app.has.todolist.models.Todo;
import my.app.has.todolist.services.ITagService;
import my.app.has.todolist.services.ITodoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/todos")
public class TodoController {

    private ITodoService todoService;
    private ITagService tagService;

    TodoController(ITodoService todoService, ITagService tagService) {
        this.todoService = todoService;
        this.tagService = tagService;
    }

    @GetMapping("")
    ResponseEntity<List<Todo>> getList() {
        List<Todo> todos = (List<Todo>) todoService.getTodoList();
        return new ResponseEntity<>(todos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    ResponseEntity<Todo> getDetail(@PathVariable Long id) {
        Todo todo = todoService.getTodoDetail(id);
        return new ResponseEntity<>(todo, HttpStatus.OK);
    }

    @PostMapping("")
    ResponseEntity<Todo> add(@RequestBody Todo todo) {
        Todo insertedTodo = todoService.save(todo);
        return new ResponseEntity<>(insertedTodo, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    ResponseEntity<Todo> add(@PathVariable Long id, @RequestBody Todo todo) {
        Todo insertedTodo = todoService.update(id, todo);
        return new ResponseEntity<>(insertedTodo, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable Long id) {
        boolean isDeleted = todoService.delete(id);
        HttpStatus status = HttpStatus.NOT_FOUND;
        if (isDeleted) {
            status = HttpStatus.OK;
        }
        return new ResponseEntity<>(status);
    }

    @GetMapping("/tags")
    ResponseEntity<Iterable<Todo>> getTodoByTags(@RequestParam String ids) {
        Set<Long> tagIdList = new HashSet<>();

        if (!ids.trim().isEmpty()) {
            String[] tags = ids.split(",");
            for (String tagId : tags) {
                tagIdList.add(Long.parseLong(tagId.trim()));
            }
        }

        Iterable<Tag> tags = tagService.getAllByIds(tagIdList);
        Iterable<Todo> todoList = todoService.getTodoByTags(tags);
        return new ResponseEntity<>(todoList, HttpStatus.OK);
    }
}
