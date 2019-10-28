package my.app.has.todolist.repositories;

import my.app.has.todolist.models.Todo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITodoRepository extends CrudRepository<Todo, Long> {
}
