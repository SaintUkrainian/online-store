package com.github.saintukrainian.storebackend.formattedentities;

public class ProductFormatted {

    private Integer id;

    private String name;

    private String description;

    private Float price;

    private Integer typeId;

    private String typeName;

    public ProductFormatted() {

    }

    public ProductFormatted(Integer id, String name, String description,
            Float price, Integer typeId, String typeName) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.typeId = typeId;
        this.typeName = typeName;
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

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
