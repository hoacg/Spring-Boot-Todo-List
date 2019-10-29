package my.app.has.todolist.repositories;

import my.app.has.todolist.models.Category;
import my.app.has.todolist.models.Todo;
import org.springframework.data.repository.CrudRepository;

public interface ITodoRepository extends CrudRepository<Todo, Long> {
    Iterable<Todo> findAllByCategory(Category category);
}
