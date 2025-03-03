package com.ecom.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Getter
@Setter
public class ProductRequestResponse {

    private Long prodId;
    private String prodName;
    private String prodDescription;
    private Double price;
    private Long stock;
    private List<ProductImages> images;
    private List<String> prodImages;
    private String status;
    private String message;
    private Product product;

    public String getProdName() {
        return prodName;
    }

    public String getProdDescription() {
        return prodDescription;
    }

    public Double getPrice() {
        return price;
    }

    public Long getStock() {
        return stock;
    }

    public List<ProductImages> getImages() {
        return images;
    }

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public Product getProduct() {
        return product;
    }

    public Long getProdId() {
        return prodId;
    }

    public void setProdId(Long prodId) {
        this.prodId = prodId;
    }

    public void setProdName(String name) {
        this.prodName = name;
    }

    public void setProdDescription(String description) {
        this.prodDescription = description;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setStock(Long stock) {
        this.stock = stock;
    }

    public void setImages(List<ProductImages> images) {
        this.images = images;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public List<String> getProdImages() {
        return prodImages;
    }

    public void setProdImages(List<String> prodImages) {
        this.prodImages = prodImages;
    }
}
