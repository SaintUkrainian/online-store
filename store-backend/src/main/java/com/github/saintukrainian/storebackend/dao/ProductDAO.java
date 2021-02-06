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

    public List<Product> findByTypeId(Integer typeId) {
        Session session = entityManager.unwrap(Session.class);
        Query<Product> findByTypeQuery = session
                .createQuery("from Product where type.id =: typeId", Product.class);
        findByTypeQuery.setParameter("typeId", typeId);

        return findByTypeQuery.getResultList();
    }
}
