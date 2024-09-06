package com.yash.productservicejune24.services;

import com.yash.productservicejune24.exceptions.CategoryNotFoundException;
import com.yash.productservicejune24.models.Category;
import com.yash.productservicejune24.respositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SelfCategoryService implements CategoryService{

    private CategoryRepository categoryRepository;

    public SelfCategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category getCategoryById(Long id) throws CategoryNotFoundException {
        Optional<Category> category = categoryRepository.findById(id);

        if(category.isEmpty()){
            throw new CategoryNotFoundException("Category with id: " + id + "not found in database");
        }

        return category.get();
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
}
