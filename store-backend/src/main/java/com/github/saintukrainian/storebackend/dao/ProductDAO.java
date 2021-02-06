package com.github.saintukrainian.storebackend.dao;

import com.github.saintukrainian.storebackend.entity.Product;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

import java.util.List;

@Repository
public class ProductDAO {
    private EntityManager entityManager;

    public ProductDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Product> findByType(String type) {
        Session session = entityManager.unwrap(Session.class);
        Query<Product> findByTypeQuery = session
                .createQuery("from Product where type =: type", Product.class);
        findByTypeQuery.setParameter("type", type);

        return findByTypeQuery.getResultList();
    }
}
