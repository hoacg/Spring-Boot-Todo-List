package my.app.has.products.services;

import my.app.has.products.models.CategoryProduct;

public interface ICategoryProductService {
    public Iterable<CategoryProduct> getCategories();
    public CategoryProduct addCategory(CategoryProduct categoryProduct);
}
