package com.shubh.starter.restapi.controller;


import com.shubh.starter.restapi.model.MProduct;
import com.shubh.starter.restapi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    // Get all products
    @GetMapping
    public List<MProduct> getAllProducts() {
        return productService.getAllProducts();
    }

    // Get a product by ID
    @GetMapping("/{id}")
    public ResponseEntity<MProduct> getProductById(@PathVariable Long id) {
        return productService.getProductById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Add a new product
    @PostMapping
    public MProduct addProduct(@RequestBody MProduct product) {
        return productService.addProduct(product);
    }

    // Update a product
    @PutMapping("/{id}")
    public ResponseEntity<MProduct> updateProduct(@PathVariable Long id, @RequestBody MProduct productDetails) {
        return ResponseEntity.ok(productService.updateProduct(id, productDetails));
    }

    // Delete a product
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}