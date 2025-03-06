package com.ecom.serviceImplementation;

import com.ecom.entity.Product;
import com.ecom.entity.ProductImages;
import com.ecom.entity.ProductRequestResponse;
import com.ecom.repository.ProductRepository;
import com.ecom.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public ProductRequestResponse saveProduct(ProductRequestResponse request) {
        ProductRequestResponse response = new ProductRequestResponse();
        Product product = new Product();

        product.setProdName(request.getProdName());
        product.setProdDescription(request.getProdDescription());
        product.setStock(request.getStock());
        product.setPrice(request.getPrice());
        List<ProductImages> images = new ArrayList<>();
        for(int i=0;i<request.getImages().size();i++){
            ProductImages image= request.getImages().get(i);
            image.setProduct(product);
            images.add(image);
        }

        product.setImages(images);

        Product prod = productRepository.save(product);
        if(prod.getProdId()>0){
            response.setMessage("Product saved successfully!");
        }
        else{
            response.setMessage("Product not saved");
        }
        return response;
    }

    @Override
    public ProductRequestResponse deleteProduct(Long id) {
        ProductRequestResponse response = new ProductRequestResponse();
        Product prod = productRepository.findByProdId(id);
        if(prod!=null){
            productRepository.delete(prod);
            response.setMessage("Product deleted successfully");
        }
        else{
            response.setMessage("Cannot delete product");
        }
        return response;
    }

    @Override
    public List<ProductRequestResponse> getProducts() {
        List<Product> products = productRepository.findAll();
        List<ProductRequestResponse> prods = new ArrayList<>();

        for(Product prod:products){
            ProductRequestResponse response = new ProductRequestResponse();
            //response.setProduct(prod);
            response.setProdId(prod.getProdId());
            response.setProdName(prod.getProdName());
            response.setProdDescription(prod.getProdDescription());
            response.setStock(prod.getStock());
            response.setPrice(prod.getPrice());
            List<String> images = prod.getImages().stream()
                            .map(ProductImages::getImageUrl)
                                    .toList();
            response.setProdImages(images);
            prods.add(response);
        }
        return prods;
    }

    @Override
    public ProductRequestResponse updateProduct(Long id,ProductRequestResponse request) {
        ProductRequestResponse response = new ProductRequestResponse();
        Product existingProduct = productRepository.findByProdId(id);
        
        if(existingProduct!=null){
            existingProduct.setProdName(request.getProdName());
            existingProduct.setProdDescription(request.getProdDescription());
            existingProduct.setStock(request.getStock());
            existingProduct.setPrice(request.getPrice());
//            List<ProductImages> images = new ArrayList<>();
//            for(int i=0;i<request.getImages().size();i++){
//                ProductImages image = request.getImages().get(i);
//                image.setProduct(existingProduct);
//                images.add(image);
//            }

            //existingProduct.setImages(images);

            Product prod = productRepository.save(existingProduct);
            if(prod.getProdId()>0){
                response.setMessage("Product updated successfully!");
            }
            else{
                response.setMessage("Product not saved");
            }
        }
        return response;
    }

    @Override
    public ProductRequestResponse addImages(ProductRequestResponse request, Long prodId) {
        ProductRequestResponse response = new ProductRequestResponse();
        Product product = productRepository.findByProdId(prodId);
        System.out.println("product "+product);
        List<ProductImages> prodImages = product.getImages();
        for(int i=0;i<request.getImages().size();i++){
            ProductImages image = request.getImages().get(i);
            image.setImageUrl(image.getImageUrl());
            image.setProduct(product);
            prodImages.add(image);
        }
        product.setImages(prodImages);
        Product prod = productRepository.save(product);
        List<String> images = prod.getImages().stream()
                .map(ProductImages::getImageUrl)
                .toList();
        if(prod.getProdId()>0){
            response.setMessage("Images added successfully");
            response.setProdImages(images);
        }
        return response;
    }
}
