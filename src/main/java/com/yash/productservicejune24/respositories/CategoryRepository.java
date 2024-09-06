package com.yash.productservicejune24.respositories;

import com.yash.productservicejune24.models.Category;
import com.yash.productservicejune24.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {
    public Optional<Category> findById(Long id);
    public Category save(Category category);
    public List<Category> findAll();
}
