package com.example.ProductServiceProxy.services;

import com.example.ProductServiceProxy.clients.ClientProductDtoInterface;
import com.example.ProductServiceProxy.models.Product;
import com.example.ProductServiceProxy.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SelfProductService implements ProductServiceInterface{
    ProductRepository productRepository;

    public SelfProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }
    @Override
    public List<Product> getAllProducts() {
        return null;
    }

    @Override
    public Product getSingleProduct(Long productId) {
        return null;
    }

//    @Override
//    public Product addNewProduct(ClientProductDtoInterface productDto) {
//        /*
//        this method is to save product in 3rd party Client like fakestoreapi.com,
//        so we will implement this method in FakeStoreProductService class .
//         */
//        return null;
//    }

    @Override
    public Product addNewProduct(Product product) {
        this.productRepository.save(product);
        return product;
    }

    @Override
    public Product updateProduct(Long productId, Product product) {
        return null;
    }

    @Override
    public String deleteProduct(Long productId) {
        return null;
    }

}
