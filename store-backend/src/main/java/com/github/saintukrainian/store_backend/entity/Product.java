package com.github.saintukrainian.store_backend.entity;

import javax.persistence.*;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "product_name")
    private String name;

    @Column(name = "product_description")
    private String description;

    @Column(name = "product_price")
    private Float price;

    @Column(name = "image_url")
    private String imageUrl;

    public Product() {
    }

    public Product(Integer id, String name, String description,
            Float price, String imageUrl) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.imageUrl = imageUrl;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Product product = (Product) o;

        if (!id.equals(product.id))
            return false;
        if (!name.equals(product.name))
            return false;
        if (!description.equals(product.description))
            return false;
        if (!price.equals(product.price))
            return false;
        return imageUrl.equals(product.imageUrl);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + description.hashCode();
        result = 31 * result + price.hashCode();
        result = 31 * result + imageUrl.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", productName='" + name + '\''
                + ", productDescription='" + description + '\''
                + ", productPrice=" + price + ", imageUrl='" + imageUrl
                + '\'' + '}';
    }
}
