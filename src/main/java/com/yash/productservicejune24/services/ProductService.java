package com.yash.productservicejune24.services;

import com.yash.productservicejune24.exceptions.CategoryNotFoundException;
import com.yash.productservicejune24.exceptions.ProductNotFoundException;
import com.yash.productservicejune24.models.Product;

import java.util.List;

public interface ProductService {
    public Product getProductById(long id) throws ProductNotFoundException;
    public List<Product> getAllProducts();
    public Product updatePartialProduct(long id,Product product) throws ProductNotFoundException, CategoryNotFoundException;
    public Product updateProduct(long id,Product product);
    public Product addProduct(Product product);
    public Product deleteProduct(long id);
}
