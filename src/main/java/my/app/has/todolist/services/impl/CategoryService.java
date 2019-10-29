package my.app.has.todolist.services.impl;

import my.app.has.todolist.models.Category;
import my.app.has.todolist.repositories.ICategoryRepository;
import my.app.has.todolist.services.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    ICategoryRepository categoryRepository;

    @Override
    public List<Category> getList() {
        return (List<Category>) categoryRepository.findAll();
    }

    @Override
    public Optional<Category> getDetail(Long id) {
        return categoryRepository.findById(id);
    }

    @Override
    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category updateById(Long id, Category category) {
        Optional<Category> existedCatOpt = categoryRepository.findById(id);
        Category updatedCategory;
        if (existedCatOpt.isPresent()) {
            Category existedCat = existedCatOpt.get();
            existedCat.setTitle(category.getTitle());
            updatedCategory = categoryRepository.save(existedCat);
        } else {
            updatedCategory = categoryRepository.save(category);
        }
        return updatedCategory;
    }
}
