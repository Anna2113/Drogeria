package com.example.drogeria.service;

import com.example.drogeria.entity.Product;
import com.example.drogeria.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public Optional<Product> findProductById(Long id) {
        return productRepository.findById(id);
    }

    public Product savePrduct(Product product) {
        return productRepository.save(product);
    }
}
