package my.app.has.todolist.services;

import my.app.has.todolist.models.Todo;
import my.app.has.todolist.repositories.ITodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService implements ITodoService {

    @Autowired
    ITodoRepository todoRepository;

    public Iterable<Todo> getTodoList() {
        return todoRepository.findAll();
    }
}
