package com.ecom.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Product {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long prodId;
    private String prodName;
    private String prodDescription;
    private Long stock;
    private Double price;
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductImages> images;

    public Long getProdId() {
        return prodId;
    }

    public String getProdName() {
        return prodName;
    }

    public String getProdDescription() {
        return prodDescription;
    }

    public Long getStock() {
        return stock;
    }

    public Double getPrice() {
        return price;
    }

    public List<ProductImages> getImages() {
        return images;
    }

    public void setProdId(Long prodId) {
        this.prodId = prodId;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public void setProdDescription(String prodDescription) {
        this.prodDescription = prodDescription;
    }

    public void setStock(Long stock) {
        this.stock = stock;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setImages(List<ProductImages> images) {
        this.images = images;
    }
}
