package com.example.ProductServiceProxy.services;

import com.example.ProductServiceProxy.clients.ClientProductDtoInterface;
import com.example.ProductServiceProxy.dtos.ProductDto;
import com.example.ProductServiceProxy.models.Product;

import java.util.List;

public interface ProductServiceInterface {
    List<Product> getAllProducts();

    Product getSingleProduct(Long productId);

//    Product addNewProduct(ClientProductDtoInterface productDto);
//    Product addNewProduct(Product product);

    Product addNewProduct(Product product);

    Product updateProduct(Long productId, Product product);

    String deleteProduct(Long productId);
}
