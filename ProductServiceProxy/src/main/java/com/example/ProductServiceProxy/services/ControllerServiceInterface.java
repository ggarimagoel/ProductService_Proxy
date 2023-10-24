package com.example.ProductServiceProxy.services;

import com.example.ProductServiceProxy.dtos.CategoryDto;

public interface ControllerServiceInterface {
    String getAllCategories();

    String getSingleCategory(Long CategoryId);

    String addNewCategory(CategoryDto categoryDto);

    String deleteCategory(Long categoryId);

    String updateCategory(Long categoryId);
}
