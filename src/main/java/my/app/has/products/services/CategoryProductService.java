package my.app.has.products.services;

import my.app.has.products.models.CategoryProduct;
import my.app.has.products.repository.CategoryProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryProductService implements ICategoryProductService {

    @Autowired
    private CategoryProductRepository categoryRepository;

    @Override
    public Iterable<CategoryProduct> getCategories() {
        return this.categoryRepository.findAll();
    }

    @Override
    public CategoryProduct addCategory(CategoryProduct categoryProduct) {
        return this.categoryRepository.save(categoryProduct);
    }
}
