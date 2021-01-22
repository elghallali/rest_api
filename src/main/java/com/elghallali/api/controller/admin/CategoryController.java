package com.elghallali.api.controller.admin;

import com.elghallali.api.model.Category;
import com.elghallali.api.model.Product;
import com.elghallali.api.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/admin")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @RequestMapping("/categories")
    public List<Category> getCategories(){
        return categoryService.getCategories();
    }

    @PostMapping("/categories")
    public Category createCategory(Category category){
        return categoryService.createCategory(category);
    }

    @DeleteMapping("/categories/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteProduct(@PathVariable Long id) {
        Category category = categoryService.getCategory(id);
        categoryService.deleteCategory(category.getId());
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }


}
