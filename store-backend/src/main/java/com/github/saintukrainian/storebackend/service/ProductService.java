package com.github.saintukrainian.storebackend.service;

import com.github.saintukrainian.storebackend.dao.ProductDAO;
import com.github.saintukrainian.storebackend.dao.ProductRepository;
import com.github.saintukrainian.storebackend.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private ProductRepository productRepository;
    private ProductDAO productDAO;

    @Autowired
    public ProductService(ProductRepository productRepository, ProductDAO productDAO) {
        this.productRepository = productRepository;
        this.productDAO = productDAO;
    }

    public Optional<Product> findById(int id) {
        return productRepository.findById(id);
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public List<Product> findByTypeId(Integer type) {
        return productDAO.findByTypeId(type);
    }
}
