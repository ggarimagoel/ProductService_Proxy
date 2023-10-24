package com.example.ProductServiceProxy.controllers;


import com.example.ProductServiceProxy.clients.ClientProductDtoInterface;
import com.example.ProductServiceProxy.dtos.ProductDto;
import com.example.ProductServiceProxy.models.Categories;
import com.example.ProductServiceProxy.models.Product;
import com.example.ProductServiceProxy.services.ProductServiceInterface;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;


// this controller will always answer /products
@RestController
@RequestMapping("/products")
public class ProductController {
    ProductServiceInterface productService;

    public ProductController(ProductServiceInterface productService){
        this.productService = productService;           // interface helps us in loose coupling
    }

    // GET call in GetMapping will actually call the method for productid  related to it i.e. getSingleProduct()
    @GetMapping("/{id}")
    public ResponseEntity<Product> getSingleProduct(@PathVariable("id") Long productId){
        try {
            // to add headers
            MultiValueMap<String, String> headers = new LinkedMultiValueMap<>() ; // to add headers, inbuilt interface
            headers.add("Content-Type", "application/json");
            headers.add("Accept", "application/json");


            Product product = productService.getSingleProduct(productId);
            if(productId < 1 ){
                throw new IllegalArgumentException("Product id cannot be less than 1");
            }
            ResponseEntity<Product> responseEntity = new ResponseEntity<>(product,headers, HttpStatus.OK);
            return responseEntity;
        }catch (Exception e){
//            ResponseEntity<Product> responseEntity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//            return new ResponseEntity<>( HttpStatus.INTERNAL_SERVER_ERROR);
              throw e;
        }
    }


    // this will return all products bec we are calling a collection of product not a single product.
//    @GetMapping("")
//    public ResponseEntity<List<Product>> getAllProducts(){
//        try {
//            return new ResponseEntity<>(this.productService.getAllProducts(), HttpStatus.OK);
//        }catch (Exception e){
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }

    // when we add any product we will get info about its specifications from ProductDto
    @PostMapping("")
    public ResponseEntity<Product> addNewProduct(@RequestBody ProductDto productDto){
        Product product = getProduct(productDto);
        Product productsaved = this.productService.addNewProduct(product);
        ResponseEntity<Product> responseEntity = new ResponseEntity<>(productsaved, HttpStatus.OK);
        return responseEntity;
    }

    @PatchMapping("/{id}")
    public Product patchProduct(@PathVariable("id") Long productId , @RequestBody ProductDto productDto){

        Product product = new Product();
        product.setId(productDto.getId());
        product.setTitle(productDto.getTitle());
        product.setPrice(productDto.getPrice());
        Categories category = new Categories();
        category.setName(productDto.getCategory());
        product.setImageUrl(productDto.getImageUrl());

        Product product1 = this.productService.updateProduct(productId,product);
        return product1;
    }

    @PutMapping("/{id}")
    public String updateProduct(@PathVariable("id") Long productId){
        return "updating product" + productId;
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable("id") Long productId) {
        return "Deleting a product with id: " + productId;
    }

//    @ExceptionHandler({NullPointerException.class,IllegalArgumentException.class, HttpClientErrorException.NotFound.class})
    public ResponseEntity<String> handleException(Exception e){
        return new ResponseEntity<>("error has occoured", HttpStatus.INTERNAL_SERVER_ERROR);
    }
    private Product getProduct(ProductDto productDto) {
        Product product = new Product();
        product.setId(productDto.getId());
        product.setTitle(productDto.getTitle());
        product.setPrice(productDto.getPrice());
        Categories category = new Categories();
        category.setName(productDto.getCategory());
        product.setCategory(category);
        product.setImageUrl(productDto.getImageUrl());
        product.setDescription(productDto.getDescription());
        return product;
    }

}


/*
Initially we have exposed our models directly to the clients and return response, which is not a good practice.
Actually FakeStoreProductService shd interact with controller to get the response and then controller shd interact with client.


ResponseEntity is a wrapper around the response that we are sending to the client.It contains
the response and the status code of the response.(Product, HttpStatus.OK).

 public ResponseEntity<Product> addNewProduct(@RequestBody FakeStoreProductDto fakeStoreProductDto){
        Product product = this.productService.addNewProduct(fakeStoreProductDto);
        ResponseEntity responseEntity = new ResponseEntity<>(product, HttpStatus.OK);
        return responseEntity;
    }
In this piece of code controller should ideally return ProductDto and not product Itself, we should change the
product int productDto here, this productDto will be specific to our Api's.


 ###public ResponseEntity<Product> addNewProduct(@RequestBody ClientProductDtoInterface productDto){}###
 add new product take ClientProductDtoInterface as input if we want to put data on third party Client, like
 fakestoreapi.com here.
BUT IT TAKES INPUT AS ProductDto ,WHEN WE WANT TO ADD DATA TO OUR OWN DATABASE.
 */