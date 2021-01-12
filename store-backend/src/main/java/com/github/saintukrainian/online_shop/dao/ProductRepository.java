package com.github.saintukrainian.online_shop.dao;

import com.github.saintukrainian.online_shop.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
