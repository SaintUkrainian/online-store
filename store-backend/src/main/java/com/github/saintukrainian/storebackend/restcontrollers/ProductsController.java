package com.github.saintukrainian.storebackend.restcontrollers;

import com.github.saintukrainian.storebackend.entity.Product;
import com.github.saintukrainian.storebackend.exceptions.ProductsNotFoundException;
import com.github.saintukrainian.storebackend.formattedentities.ProductFormatted;
import com.github.saintukrainian.storebackend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/products")
public class ProductsController {

    private ProductService productService;

    @Autowired
    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ProductsNotFoundException noSuchElement(NoSuchElementException e) {
        return new ProductsNotFoundException(e.getMessage());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ProductsNotFoundException productsNotFound(
            IllegalArgumentException e) {
        return new ProductsNotFoundException(e.getMessage());
    }

    @GetMapping("/")
    public List<Product> getProducts() {
        System.out.println("in getProducts");
        return productService.findAll();
    }

    @GetMapping("{id}")
    public Product getProductDescription(@PathVariable Integer id) {
        Optional<Product> product = productService.findById(id);
        if (product.isPresent()) {
            return product.get();
        } else {
            throw new NoSuchElementException();
        }
    }

    @GetMapping("/search")
    public List<ProductFormatted> getProductsByMultipleParams(
            @RequestParam Map<String, String> params) {
        Integer productTypeId = Integer.parseInt(params.get("typeId"));
        List<Product> productsByType = productService
                .findByTypeId(productTypeId);
        List<ProductFormatted> formattedProductsByType = productsByType.stream()
                .map(p -> {
                    ProductFormatted productFormatted = new ProductFormatted();
                    productFormatted.setDescription(p.getDescription());
                    productFormatted.setId(p.getId());
                    productFormatted.setPrice(p.getPrice());
                    productFormatted.setTypeId(p.getType().getId());
                    productFormatted.setTypeName(p.getType().getProductType());
                    productFormatted.setName(p.getName());
                    return productFormatted;
                }).collect(Collectors.toList());
        if (productsByType.size() == 0) {
            throw new IllegalArgumentException(
                    "There's no products with type id=" + productTypeId);
        }
        return formattedProductsByType;
    }
}
