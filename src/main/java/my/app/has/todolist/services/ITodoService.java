package my.app.has.todolist.services;

import my.app.has.todolist.models.Todo;
import org.springframework.stereotype.Service;

@Service
public interface ITodoService {
    Iterable<Todo> getTodoList();
    Todo getTodoDetail(Long id);
}
