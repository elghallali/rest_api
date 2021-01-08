package com.elghallali.api.service;

import com.elghallali.api.model.Category;
import com.elghallali.api.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> listProduct();

    Product getProduct(Long id);
    Product createProduct(Product product);
    Product updateProduct(Product product);
    Product deleteProduct(Long id);

    List<Product> findByCategory(Category category);

    Product updateStock(Long id, Double quantity);
}
