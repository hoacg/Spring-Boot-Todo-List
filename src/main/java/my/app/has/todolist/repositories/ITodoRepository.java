package my.app.has.todolist.repositories;

import my.app.has.todolist.models.Category;
import my.app.has.todolist.models.Tag;
import my.app.has.todolist.models.Todo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;

public interface ITodoRepository extends JpaRepository<Todo, Long> {
    Iterable<Todo> findAllByCategory(Category category);
    Set<Todo> findAllByTagsIn(Set<Tag> tags);
    @Query(value =  "SELECT p.*" +
                    "  FROM todos p" +
                    " WHERE EXISTS (SELECT NULL" +
                    "                 FROM todos_tags tg" +
                    "                WHERE tg.tag_id IN (:tagList)" +
                    "                  AND tg.todo_id = p.id" +
                    "             GROUP BY tg.todo_id" +
                    "               HAVING COUNT(*) = :tagCount)", nativeQuery = true)
    Set<Todo> findTodoByTagsHas(@Param("tagList") List<Tag> tags, @Param("tagCount")  int tagCount);
}
