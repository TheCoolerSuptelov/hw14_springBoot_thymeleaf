package com.github.thecoolersuptelov.demo.services;


import com.github.thecoolersuptelov.demo.entities.Product;
import com.github.thecoolersuptelov.demo.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsService {
    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product getById(Long id) {
        return productRepository.findById(id);
    }
    public void deleteById(Long id){
        productRepository.deleteById(id);
    }
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public void add(Product product) {
        productRepository.save(product);
    }
    public void saveEditedProduct(Long id,String newTitle, int newPrice){
        productRepository.editProduct(id, newTitle, newPrice);
    }
}
