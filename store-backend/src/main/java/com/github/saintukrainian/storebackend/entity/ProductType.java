package com.github.saintukrainian.storebackend.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "product_types")
public class ProductType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "product_type")
    private String productType;

    // type - name of property in Product class
    @OneToMany(mappedBy = "type")
    private List<Product> products;

    public ProductType() {}

    public ProductType(int id, String productType) {
        this.id = id;
        this.productType = productType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "ProductType{" + "id=" + id + ", productType='" + productType + '}';
    }
}
