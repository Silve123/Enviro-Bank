package com.eviro.assessment.grad001.kennymafuna.service;

import com.eviro.assessment.grad001.kennymafuna.entity.ProductEntity;
import com.eviro.assessment.grad001.kennymafuna.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository; // Assuming you have a ProductRepository

    @Override
    public ProductEntity getProductById(int productId) {
        return productRepository.findById(productId).orElse(null);
    }

}
