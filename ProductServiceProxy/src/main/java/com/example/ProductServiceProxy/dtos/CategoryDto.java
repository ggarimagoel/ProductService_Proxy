package com.example.ProductServiceProxy.dtos;

import com.example.ProductServiceProxy.models.Product;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Setter @Getter @ToString
public class CategoryDto {
    private String name;
    private String description;
    private List<Product> products;
}
