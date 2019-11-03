package my.app.has.todolist.services;

import my.app.has.todolist.models.Category;
import my.app.has.todolist.models.Tag;
import my.app.has.todolist.models.Todo;
import org.springframework.stereotype.Service;

@Service
public interface ITodoService {
    Iterable<Todo> getTodoList();
    Iterable<Todo> getTodoByCategory(Category category);
    Iterable<Todo> getTodoByTags(Iterable<Tag> tags);
    Todo getTodoDetail(Long id);
    Todo save(Todo todo);
    Todo update(Long id, Todo todo);
}
