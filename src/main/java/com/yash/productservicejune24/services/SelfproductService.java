package com.yash.productservicejune24.services;

import com.yash.productservicejune24.exceptions.CategoryNotFoundException;
import com.yash.productservicejune24.exceptions.ProductNotFoundException;
import com.yash.productservicejune24.models.Category;
import com.yash.productservicejune24.models.Product;
import com.yash.productservicejune24.projections.ProductWithIdAndTitle;
import com.yash.productservicejune24.respositories.CategoryRepository;
import com.yash.productservicejune24.respositories.ProductRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("selfProductService")
//@Primary
public class SelfproductService implements ProductService{

    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    public SelfproductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Product getProductById(long id) throws ProductNotFoundException {
        Optional<Product> optionalProduct = productRepository.findById(id);

        if(optionalProduct.isEmpty()){
            throw new ProductNotFoundException("Product with id:" + id +" is not present in DB");
        }

        return optionalProduct.get();
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product updatePartialProduct(long id, Product product) throws ProductNotFoundException, CategoryNotFoundException {
        Optional<Product> optionalProduct = productRepository.findById(id);

        if(optionalProduct.isEmpty()){
            throw new ProductNotFoundException("Product with id:" + id +"doesn't exist");
        }

        Product productInDB = optionalProduct.get();
        if(product.getTitle() != null){
            productInDB.setTitle(product.getTitle());
        }

        if(product.getPrice() != null){
            productInDB.setPrice(product.getPrice());
        }

        if(product.getCategory() != null){
            Optional<Category> optionalCategory = categoryRepository.findById(product.getCategory().getId());

            if(optionalCategory.isEmpty()){
                throw new CategoryNotFoundException("Category for the given id:" +
                        product.getCategory().getId() +" doesn't exist");
            }
            productInDB.setCategory(product.getCategory());
        }

        return productRepository.save(productInDB);
    }

    @Override
    public Product updateProduct(long id, Product product) {
        product.setId(id);
        return productRepository.save(product);
    }

    @Override
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product deleteProduct(long id) {
//        ProductWithIdAndTitle productWithIdAndTitle = productRepository.randomSearchMethod(id);
//        System.out.println(productWithIdAndTitle.getId() + " " + productWithIdAndTitle.getTitle());
        return null;
    }
}
