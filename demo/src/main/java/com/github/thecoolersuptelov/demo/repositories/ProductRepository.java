package com.github.thecoolersuptelov.demo.repositories;


import com.github.thecoolersuptelov.demo.entities.Product;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;


import java.util.ArrayList;
import java.util.List;


@Component
public class ProductRepository {
    private List<Product> products;

    @PostConstruct
    public void init() {
        products = new ArrayList<>();
        products.add(new Product(1L, "Bread", 40));
        products.add(new Product(2L, "Milk", 90));
        products.add(new Product(3L, "Cheese", 200));
        products.add(new Product(4L, "Corn", 10));
        products.add(new Product(5L, "Potato", 100));
        products.add(new Product(6L, "Cucumber", 132));
    }

    public List<Product> findAll() {
        return products;
    }

    public Product findByTitle(String title) {
        return products.stream().filter(p -> p.getTitle().equals(title)).findFirst().get();
    }

    public Product findById(Long id) {
        return products.stream().filter(p -> p.getId().equals(id)).findFirst().get();
    }
    public void deleteById(Long id){
        this.products.removeIf(product -> product.getId().equals(id));
    }
    public void save(Product product) {
        products.add(product);
    }
}
