package com.yash.productservicejune24.services;

import com.yash.productservicejune24.models.Product;

import java.util.List;

public interface ProductService {
    public Product getProductById(long id);
    public List<Product> getAllProducts();
}
