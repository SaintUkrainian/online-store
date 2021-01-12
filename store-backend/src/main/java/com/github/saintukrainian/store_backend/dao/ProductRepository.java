package com.github.saintukrainian.store_backend.dao;

import com.github.saintukrainian.store_backend.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
