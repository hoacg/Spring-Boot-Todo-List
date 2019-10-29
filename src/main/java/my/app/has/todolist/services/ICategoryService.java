package my.app.has.todolist.services;

import my.app.has.todolist.models.Category;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ICategoryService {
    List<Category> getList();
    Optional<Category> getDetail(Long id);
    Category save(Category category);
    Category updateById(Long id, Category category);
}
