package com.yash.productservicejune24.controllers;

import com.yash.productservicejune24.dtos.ExceptionDto;
import com.yash.productservicejune24.dtos.FakeStoreProductDto;
import com.yash.productservicejune24.exceptions.CategoryNotFoundException;
import com.yash.productservicejune24.exceptions.ProductNotFoundException;
import com.yash.productservicejune24.models.Product;
import com.yash.productservicejune24.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    ProductService productService;

    //@Autowired
    public ProductController(@Qualifier("selfProductService") ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable("id") long id) throws ProductNotFoundException {
        return productService.getProductById(id);
    }

    @GetMapping()
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @PatchMapping("/{id}")
    public Product updatePartialProduct(@PathVariable("id") long id,@RequestBody Product product) throws ProductNotFoundException, CategoryNotFoundException {
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

    @DeleteMapping("/{id}")
    public Product deleteProduct(@PathVariable("id") long id) {
        return productService.deleteProduct(id);
    }
 //   This will be given Priority over the ControllerAdvice Class
//    @ExceptionHandler(ProductNotFoundException.class)
//    public ExceptionDto handleProductNotFoundException(){
//        ExceptionDto exceptionDto = new ExceptionDto();
//
//        exceptionDto.setMessage("The product id u entered is not found, getting this error from product controller");
//        exceptionDto.setSolution("Please enter the correct product id");
//
//       return exceptionDto;
//    }
}
