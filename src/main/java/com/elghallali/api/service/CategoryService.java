package com.elghallali.api.service;

import com.elghallali.api.model.Category;

import java.util.List;

public interface CategoryService {

    List<Category> getCategories();
    Category getCategory(Long id);
    Category createCategory(Category category);
    Category updateCategory(Category category);
    Category deleteCategory(Long id);

}
