package com.github.saintukrainian.storebackend.restcontrollers;

import com.github.saintukrainian.storebackend.dao.ProductDAO;
import com.github.saintukrainian.storebackend.dao.ProductRepository;
import com.github.saintukrainian.storebackend.dao.ProductTypeRepository;
import com.github.saintukrainian.storebackend.entity.Product;
import com.github.saintukrainian.storebackend.exceptions.ProductsNotFoundException;
import com.github.saintukrainian.storebackend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/products")
public class ProductsController {

//    private ProductRepository productService;
    private ProductService productService;
    private ProductTypeRepository productTypeRepository;

    @Autowired
    public ProductsController(ProductService productService, ProductTypeRepository productTypeRepository) {
        this.productService = productService;
        this.productTypeRepository = productTypeRepository;
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ProductsNotFoundException noSuchElement(NoSuchElementException e) {
        return new ProductsNotFoundException(e.getMessage());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ProductsNotFoundException productsNotFound(IllegalArgumentException e) {
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
        if(product.isPresent()) {
            return product.get();
        } else {
            throw new NoSuchElementException();
        }
    }

    @GetMapping("/search")
    public List<Product> getProductsByMultipleParams(@RequestParam Map<String, String> params) {
        String productType = params.get("type");
//        List<Product> productsByType = productService.findByType(productType);
//        if(productsByType.size() == 0) {
//            throw new IllegalArgumentException("There's no products by type=" + productType);
//        }
        productService.findById(2).ifPresent(product -> System.out
                .println(product.getType().getProductType()));
        productTypeRepository.findById(1).ifPresent(productType1 -> System.out
                .println(productType1.getProducts()));
        return null;
    }
}
