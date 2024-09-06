package com.yash.productservicejune24.controllers;

import com.yash.productservicejune24.exceptions.CategoryNotFoundException;
import com.yash.productservicejune24.models.Category;
import com.yash.productservicejune24.services.CategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable("id") Long id) throws CategoryNotFoundException {
        return categoryService.getCategoryById(id);
    }

    @GetMapping
    public List<Category> getAllCategories(){
        return categoryService.getAllCategories();
    }
}
