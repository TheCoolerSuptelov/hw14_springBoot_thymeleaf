package com.github.thecoolersuptelov.demo.controllers;


import com.github.thecoolersuptelov.demo.entities.Product;
import com.github.thecoolersuptelov.demo.services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/products")
public class ProductsController {
    private ProductsService productsService;

    @Autowired
    public void setProductsService(ProductsService productsService) {
        this.productsService = productsService;
    }

    @GetMapping
    public String showProductsList(Model model) {
        Product product = new Product();
        model.addAttribute("products", productsService.getAllProducts());
        model.addAttribute("product", product);
        return "products";
    }

    @PostMapping("/add")
    public String addProduct(@ModelAttribute(value = "product") Product product) {
        productsService.add(product);
        return "redirect:/products";
    }

    @GetMapping("/show/{id}")
    public String showOneProduct(Model model, @PathVariable(value = "id") Long id) {
        Product product = productsService.getById(id);
        model.addAttribute("product", product);
        return "product-page";
    }

    @GetMapping("/delete/{id}")
    public String deleteOneProduct(Model model, @PathVariable(value = "id") Long id) {
        productsService.deleteById(id);
        return "redirect:/products";
    }

    @PostMapping("/save")
    public String saveEditedProduct(@ModelAttribute(value = "product") Product product)
    {
       // productsService.saveEditedProduct(id, newTitle, newPrice);
        return "redirect:/products";
    }
}
