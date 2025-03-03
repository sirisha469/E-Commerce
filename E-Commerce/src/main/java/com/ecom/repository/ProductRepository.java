package com.ecom.repository;

import com.ecom.entity.Product;
import com.ecom.entity.ProductRequestResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    public Product findByProdId(Long prodId);
}
