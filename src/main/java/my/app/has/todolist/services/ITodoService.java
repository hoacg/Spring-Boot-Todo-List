package my.app.has.todolist.services;

import my.app.has.todolist.models.Category;
import my.app.has.todolist.models.Tag;
import my.app.has.todolist.models.Todo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ITodoService {
    Iterable<Todo> getTodoList();
    Iterable<Todo> getTodoByCategory(Category category);
    List<Todo> getTodoByTags(List<Tag> tags);
    Todo getTodoDetail(Long id);
    Todo save(Todo todo);
    Todo update(Long id, Todo todo);
}
