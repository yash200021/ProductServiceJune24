package com.yash.productservicejune24.services;

import com.yash.productservicejune24.exceptions.CategoryNotFoundException;
import com.yash.productservicejune24.models.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    public Category getCategoryById(Long id) throws CategoryNotFoundException;
    public List<Category> getAllCategories();
}
