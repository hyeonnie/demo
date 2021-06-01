package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductRepository productRepository;

    @RequestMapping("/product")
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @RequestMapping("/product/{id}")
    public Product getProductById(@PathVariable("id") int id) {
        return productRepository.findById(id).get();
    }

}
