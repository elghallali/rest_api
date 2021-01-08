package com.elghallali.api.service.impl;

import com.elghallali.api.model.Category;
import com.elghallali.api.repository.CategoryRepository;
import com.elghallali.api.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategory(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    @Override
    public Category createCategory(Category category) {
        category.setEnabled(true);
        return categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(Category category) {
        Category categoryDB = this.getCategory(category.getId());
        if(categoryDB==null){
            return null;
        }
        categoryDB.setName(category.getName());
        categoryDB.setEnabled(true);
        return categoryRepository.save(categoryDB);
    }

    @Override
    public Category deleteCategory(Long id) {
        Category categoryDB = this.getCategory(id);
        if(categoryDB==null){
            return null;
        }
        categoryDB.setEnabled(false);
        return categoryRepository.save(categoryDB);
    }


}
