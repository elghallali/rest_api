package com.elghallali.api.controller.admin;

import com.elghallali.api.model.Product;
import com.elghallali.api.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/admin")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public List<Product> getAllProducts(){
        return productService.listProduct();
    }
    @PostMapping("/products")
    public Product createProduct(@RequestBody Product product){
        return productService.createProduct(product);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id){
        Product product = productService.getProduct(id);
        return ResponseEntity.ok(product);
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id){

        Product product = productService.updateProduct(productService.getProduct(id));
        return ResponseEntity.ok(product);
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteProduct(@PathVariable Long id){
        Product product = productService.getProduct(id);
        productService.deleteProduct(product.getId());
        Map<String,Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/products/{id}/stock")
    public ResponseEntity<Product> updateStock(@PathVariable Long id,Double quantity){
        Product product = productService.updateStock(productService.getProduct(id).getId(),quantity);
        return ResponseEntity.ok(product);
    }

    @GetMapping("/products/category/{id}")
    public List<Product> getProductByCategory(@PathVariable Long id){
        Product product = new Product();
        product.getCategory().setId(id);
        return productService.findByCategory(product.getCategory());
    }
}
