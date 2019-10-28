package my.app.has.todolist.controllers;

import my.app.has.todolist.models.Todo;
import my.app.has.todolist.services.ITodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/todo")
public class TodoController {

    @Autowired
    ITodoService todoService;

    @GetMapping("")
    ResponseEntity<List<Todo>> getToDos() {

        List<Todo> todos = (List<Todo>) todoService.getTodoList();

        return new ResponseEntity<>(todos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    ResponseEntity<Todo> getToDoDetail(@PathVariable Long id) {
        Todo todo = todoService.getTodoDetail(id);
        return new ResponseEntity<>(todo, HttpStatus.OK);
    }
}
