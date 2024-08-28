package com.yash.productservicejune24.services;

import com.yash.productservicejune24.dtos.FakeStoreProductDto;
import com.yash.productservicejune24.models.Category;
import com.yash.productservicejune24.models.Product;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpMessageConverterExtractor;
import org.springframework.web.client.RequestCallback;
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

    @Override
    public Product updatePartialProduct(long id,Product product) {
        String url = "https://fakestoreapi.com/products/" + id;

        FakeStoreProductDto fakeStoreProductDtoInput = new FakeStoreProductDto();
        fakeStoreProductDtoInput.setTitle(product.getTitle());
        fakeStoreProductDtoInput.setPrice(product.getPrice());
        //fakeStoreProductDtoInput.setDescription(product.getCategory().getDescription());

       // RequestCallback requestCallback = restTemplate.httpEntityCallback(fakeStoreProductDtoInput, FakeStoreProductDto.class);
        //HttpMessageConverterExtractor<FakeStoreProductDto> responseExtractor =
         //       new HttpMessageConverterExtractor<>(FakeStoreProductDto.class, restTemplate.getMessageConverters());
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<FakeStoreProductDto> httpEntity = new HttpEntity<>(fakeStoreProductDtoInput, httpHeaders);
        ResponseEntity<FakeStoreProductDto> fakeStoreProductDto = restTemplate.exchange(url, HttpMethod.PATCH, httpEntity, FakeStoreProductDto.class);
        return getProductFromFSProduct(fakeStoreProductDto.getBody());
    }

    @Override
    public Product updateProduct(long id, Product product) {
        String url = "https://fakestoreapi.com/products/" + id;
        FakeStoreProductDto fakeStoreProductDtoInput = new FakeStoreProductDto();
        fakeStoreProductDtoInput.setTitle(product.getTitle());
        fakeStoreProductDtoInput.setPrice(product.getPrice());
        //fakeStoreProductDtoInput.setDescription(product.getCategory().getDescription());

        RequestCallback requestCallback = restTemplate.httpEntityCallback(fakeStoreProductDtoInput, FakeStoreProductDto.class);
        HttpMessageConverterExtractor<FakeStoreProductDto> responseExtractor =
                new HttpMessageConverterExtractor<>(FakeStoreProductDto.class, restTemplate.getMessageConverters());
        FakeStoreProductDto fakeStoreProductDto = restTemplate.execute(url, HttpMethod.PUT, requestCallback, responseExtractor);
        return getProductFromFSProduct(fakeStoreProductDto);
    }

    @Override
    public Product addProduct(Product product) {
        String url = "https://fakestoreapi.com/products";
        FakeStoreProductDto fakeStoreProductDtoInput = new FakeStoreProductDto();
        fakeStoreProductDtoInput.setTitle(product.getTitle());
        fakeStoreProductDtoInput.setPrice(product.getPrice());
        fakeStoreProductDtoInput.setDescription(product.getCategory().getDescription());
        FakeStoreProductDto fakeStoreProductDto = restTemplate.postForObject(url, fakeStoreProductDtoInput, FakeStoreProductDto.class);
        return getProductFromFSProduct(fakeStoreProductDto);
    }

    @Override
    public Product deleteProduct(long id) {
        String url = "https://fakestoreapi.com/products/" + id;
        restTemplate.delete(url);
        return null;
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
