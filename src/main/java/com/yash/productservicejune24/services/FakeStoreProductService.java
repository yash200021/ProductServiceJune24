package com.yash.productservicejune24.services;

import com.yash.productservicejune24.dtos.FakeStoreProductDto;
import com.yash.productservicejune24.models.Category;
import com.yash.productservicejune24.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreProductService implements ProductService{

    private RestTemplate restTemplate;

    public FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Product getProductById(long id) {
        String url = "https://fakestoreapi.com/products/" + id;
        FakeStoreProductDto fakeStoreProductDto = restTemplate.getForObject(url, FakeStoreProductDto.class);
        return getProductFromFSProduct(fakeStoreProductDto);
    }

    @Override
    public List<Product> getAllProducts() {
        String url = "https://fakestoreapi.com/products";
        FakeStoreProductDto[] fakeStoreProductDtos = restTemplate.getForObject(url, FakeStoreProductDto[].class);

        List<Product> products = new ArrayList<>();
        for(FakeStoreProductDto fakeStoreProductDto : fakeStoreProductDtos){
            products.add(getProductFromFSProduct(fakeStoreProductDto));
        }
        return products;
    }

    public Product getProductFromFSProduct(FakeStoreProductDto fakeStoreProductDto){
        Product product = new Product();
        product.setId(fakeStoreProductDto.getId());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setPrice(fakeStoreProductDto.getPrice());

        Category category = new Category();
        category.setDescription(fakeStoreProductDto.getDescription());
        product.setCategory(category);

        return product;
    }
}
