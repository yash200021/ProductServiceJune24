package com.yash.productservicejune24.controllers;

import com.yash.productservicejune24.dtos.FakeStoreProductDto;
import com.yash.productservicejune24.models.Product;
import com.yash.productservicejune24.services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable("id") long id) {
        return productService.getProductById(id);
    }

    @GetMapping()
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @PatchMapping("/{id}")
    public Product updatePartialProduct(@PathVariable("id") long id,@RequestBody Product product) {
        return productService.updatePartialProduct(id,product);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable("id") long id,@RequestBody Product product) {
        return productService.updateProduct(id,product);
    }

    @PostMapping()
    public Product addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }

    public Product deleteProduct(@PathVariable("id") long id) {
        return productService.deleteProduct(id);
    }
}
