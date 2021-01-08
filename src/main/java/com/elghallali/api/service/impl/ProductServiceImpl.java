package com.elghallali.api.service.impl;

import com.elghallali.api.model.Category;
import com.elghallali.api.model.Product;
import com.elghallali.api.repository.ProductRepository;
import com.elghallali.api.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> listProduct() {
        return productRepository.findAll();
    }

    @Override
    public Product getProduct(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public Product createProduct(Product product) {
        product.setStatus("CREATED");
        product.setCreateAt(new Date());
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Product product) {
        Product productDB = this.getProduct(product.getId());
        if(productDB==null){
            return null;
        }
            productDB.setName(product.getName());
            productDB.setDescription(product.getDescription());
            productDB.setCategory(product.getCategory());
            productDB.setPrice(product.getPrice());
            productDB.setStatus("UPDATED");
        return productRepository.save(productDB);
    }

    @Override
    public Product deleteProduct(Long id) {
        Product productDB=this.getProduct(id);
        if(productDB==null){
            return null;
        }
        productDB.setStatus("DELETED");
        return productRepository.save(productDB);
    }

    @Override
    public List<Product> findByCategory(Category category) {
        return productRepository.findByCategory(category);
    }

    @Override
    public Product updateStock(Long id, Double quantity) {
        Product productDB=this.getProduct(id);
        if(productDB==null){
            return null;
        }
        Double stock = productDB.getStock() + quantity;
        productDB.setStock(stock);
        productDB.setStatus("UPDATED");
        return productRepository.save(productDB);
    }
}
