package com.example.ProductServiceProxy.services;

import com.example.ProductServiceProxy.dtos.CategoryDto;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@Service
public class ControllerService implements ControllerServiceInterface {
    @Override
    public String getAllCategories() {return "Getting all Categories";}
    @Override
    public String getSingleCategory(Long CategoryId){return "Getting single Category" + CategoryId;}
    @Override
    public String addNewCategory(CategoryDto categoryDto){return "Adding new Category";}
    @Override
    public String deleteCategory(Long categoryId){
        return "deleting  Category";
    }
    @Override
    public String updateCategory(Long categoryId){
        return "updating new Category";
    }
}
