package com.github.saintukrainian.store_backend.rest_controllers;

import com.github.saintukrainian.store_backend.dao.ProductRepository;
import com.github.saintukrainian.store_backend.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/products")
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

    @GetMapping("/")
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @GetMapping("{id}")
    public Product getProductDescription(@PathVariable Integer id) {
        Optional<Product> product = productRepository.findById(id);
        if(product.isPresent()) {
            return product.get();
        } else {
            throw new NoSuchElementException();
        }
    }
}
