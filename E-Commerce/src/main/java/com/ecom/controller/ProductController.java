package com.ecom.controller;

import com.ecom.entity.Product;
import com.ecom.entity.ProductImages;
import com.ecom.entity.ProductRequestResponse;
import com.ecom.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;
    @PostMapping("/save")
    public ResponseEntity<ProductRequestResponse> saveProduct(@RequestBody ProductRequestResponse product){
        ProductRequestResponse response = productService.saveProduct(product);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ProductRequestResponse> deleteProduct(@RequestParam Long prodId){
        return ResponseEntity.ok(productService.deleteProduct(prodId));
    }

    @GetMapping("/get-all-products")
    public ResponseEntity<List<ProductRequestResponse>> getProducts(){
        return ResponseEntity.ok(productService.getProducts());
    }

    @PutMapping("/update")
    public ResponseEntity<ProductRequestResponse> updateProduct(@RequestParam Long prodId,@RequestBody ProductRequestResponse request){
        return ResponseEntity.ok(productService.updateProduct(prodId,request));
    }

    @PostMapping("/add-only-images")
    public ResponseEntity<ProductRequestResponse> addImages(@RequestParam Long prodId,@RequestBody ProductRequestResponse request){
        return ResponseEntity.ok(productService.addImages(request,prodId));
    }
}
