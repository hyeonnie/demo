package com.example.demo;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

    @Autowired
    private ProductRepository productRepository;

    @Bean
    public ApplicationRunner applicationRunner() {
        return args -> {
            productRepository.save(new Product(1, "iPad 4 Mini", 500.01, 2));
            productRepository.save(new Product(2, "H&M T-Shirt White", 10.99, 10));
            productRepository.save(new Product(3, "Charli XCX - Sucker CD", 19.99, 5));
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
