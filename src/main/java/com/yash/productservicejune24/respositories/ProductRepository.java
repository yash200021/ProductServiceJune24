package com.yash.productservicejune24.respositories;

import com.yash.productservicejune24.models.Product;
import com.yash.productservicejune24.projections.ProductWithIdAndTitle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    public Optional<Product> findById(long id);
    public List<Product> findAll();
    public Product save(Product product);

    //HQL
    @Query("select p.id as id, p.title as title from Product p where p.id = :x")
    ProductWithIdAndTitle randomSearchMethod(Long x);
}
