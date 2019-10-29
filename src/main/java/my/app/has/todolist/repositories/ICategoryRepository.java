package my.app.has.todolist.repositories;

import my.app.has.todolist.models.Category;
import org.springframework.data.repository.CrudRepository;

public interface ICategoryRepository extends CrudRepository<Category, Long> {
}
