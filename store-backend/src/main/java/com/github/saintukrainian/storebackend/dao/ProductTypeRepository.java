package com.github.saintukrainian.storebackend.dao;

import com.github.saintukrainian.storebackend.entity.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductTypeRepository extends JpaRepository<ProductType, Integer> {
}
