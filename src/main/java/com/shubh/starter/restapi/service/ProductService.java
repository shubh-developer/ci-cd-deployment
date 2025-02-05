package com.shubh.starter.restapi.service;



import com.shubh.starter.restapi.model.MProduct;
import com.shubh.starter.restapi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private  ProductRepository productRepository;

    // Get all products
    public List<MProduct> getAllProducts() {
        return productRepository.findAll();
    }

    // Get a product by ID
    public Optional<MProduct> getProductById(Long id) {
        return productRepository.findById(id);
    }

    // Add a new product
    public MProduct addProduct(MProduct product) {
        return productRepository.save(product);
    }

    // Update a product
    public MProduct updateProduct(Long id, MProduct productDetails) {
        MProduct product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        product.setName(productDetails.getName());
        product.setPrice(productDetails.getPrice());
        return productRepository.save(product);
    }

    // Delete a product
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}