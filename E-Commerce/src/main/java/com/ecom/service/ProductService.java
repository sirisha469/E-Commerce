package com.ecom.service;

import com.ecom.entity.Product;
import com.ecom.entity.ProductRequestResponse;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
public interface ProductService {

    public ProductRequestResponse saveProduct(ProductRequestResponse request);

    public ProductRequestResponse deleteProduct(Long id);

    public List<ProductRequestResponse> getProducts();

    public ProductRequestResponse updateProduct(Long id,ProductRequestResponse request);
}
