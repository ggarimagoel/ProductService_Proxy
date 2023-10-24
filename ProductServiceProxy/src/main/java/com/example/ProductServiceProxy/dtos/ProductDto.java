package com.example.ProductServiceProxy.dtos;

import com.example.ProductServiceProxy.models.Categories;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class ProductDto {
    private Long id;
    private String title;
    private String description;
    private double price;
    private String category;
    private String imageUrl;
    private RatingDto rating;
}

/*
The Dto will have all the parameters of fakestoreapi object,
 bec service will be using this dto to get the data from fakestoreapi
 */

/*
In Product.class we have category as an object of Categories class, but in ProductDto.class
we have category as a string(as per specified in fake store api).
 */