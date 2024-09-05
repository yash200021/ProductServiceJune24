package com.yash.productservicejune24;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
// I am using it temporarily to excldue the non-necessary tables from getting created and making my code simple.
// The package , I have excluded is inheritancetypes, which we can use later when needed.
@EntityScan(basePackages = "com.yash.productservicejune24.models")
public class ProductServiceJune24Application {

    public static void main(String[] args) {
        SpringApplication.run(ProductServiceJune24Application.class, args);
    }

}
