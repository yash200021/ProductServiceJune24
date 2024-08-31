package com.yash.productservicejune24.exceptions;

import org.springframework.web.bind.annotation.ControllerAdvice;

public class CategoryNotFoundException extends Exception{

    public CategoryNotFoundException(String message){
        super(message);
    }
}
