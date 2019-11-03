package my.app.has.todolist.services.impl;

import my.app.has.todolist.models.Category;
import my.app.has.todolist.models.Tag;
import my.app.has.todolist.models.Todo;
import my.app.has.todolist.repositories.ITodoRepository;
import my.app.has.todolist.services.ITodoService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TodoService implements ITodoService {

    private ITodoRepository todoRepository;

    TodoService(ITodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public Iterable<Todo> getTodoList() {
        return todoRepository.findAll();
    }

    @Override
    public Iterable<Todo> getTodoByCategory(Category category) {
        return todoRepository.findAllByCategory(category);
    }

    @Override
    public Iterable<Todo> getTodoByTags(Iterable<Tag> tags) {
        List<Tag> tagsList = (List<Tag>) tags;
        boolean isFindAll = tagsList.size() == 0;
        return (isFindAll)
                ? todoRepository.findAll()
                : todoRepository.findTodoByTagsHas(tagsList, tagsList.size());
    }

    @Override
    public Todo getTodoDetail(Long id) {
        Optional<Todo> optional = todoRepository.findById(id);

        return optional.orElse(null);
    }

    @Override
    public Todo save(Todo todo) {
        return todoRepository.save(todo);
    }

    public Todo update(Long id, Todo todo) {
        Optional<Todo> existed = todoRepository.findById(id);
        Todo updatedTodo = new Todo();
        if (existed.isPresent()) {
            updatedTodo = existed.get();
            updatedTodo.setCategory(todo.getCategory());
            updatedTodo.setTags(todo.getTags());
            updatedTodo = todoRepository.save(updatedTodo);
        }
        return updatedTodo;
    }
}
