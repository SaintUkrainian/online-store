package com.github.saintukrainian.online_shop.rest_controllers;

import com.github.saintukrainian.online_shop.dao.ProductRepository;
import com.github.saintukrainian.online_shop.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
public class ProductsController {

    private ProductRepository productRepository;

    @Autowired
    public ProductsController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String noSuchElement(NoSuchElementException e) {
        return "There's no such element!";
    }

    @GetMapping("/products")
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @GetMapping("/products/{id}")
    public Product getProductDescription(@PathVariable Integer id) {
        Optional<Product> product = productRepository.findById(id);
        if(product.isPresent()) {
            return product.get();
        } else {
            throw new NoSuchElementException();
        }
    }
}
