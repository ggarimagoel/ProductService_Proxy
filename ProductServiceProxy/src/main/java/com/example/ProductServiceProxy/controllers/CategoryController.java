package com.example.ProductServiceProxy.controllers;


import com.example.ProductServiceProxy.dtos.CategoryDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products/categories")
public class CategoryController {

    @GetMapping("")
    public String getAllCategories() {
        return "Getting all Categories";
    }
    @GetMapping("/{id}")
    public String getProductsInCategory(@PathVariable("id") Long categoryId) throws Exception {
        if(categoryId <1){
            throw new Exception("Category id cannot be less than 1");
        }
        return "Getting products in Category" ;
    }

    @PostMapping("")
    public String addNewCategory(CategoryDto categoryDto){
        return "Adding new Category";
    }
    @PutMapping("/{id}")
    public String updateCategory(Long categoryId){
        return "deleting new Category";
    }
    @DeleteMapping("/{id}")
    public String deleteCategory(Long categoryId){
        return "updating new Category";
    }

}
