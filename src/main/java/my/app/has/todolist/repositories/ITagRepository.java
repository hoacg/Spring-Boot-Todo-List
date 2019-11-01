package my.app.has.todolist.repositories;

import my.app.has.todolist.models.Tag;
import org.springframework.data.repository.CrudRepository;

public interface ITagRepository extends CrudRepository<Tag, Long> {
}
