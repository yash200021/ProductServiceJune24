package com.yash.productservicejune24.controlleradvice;

import com.yash.productservicejune24.dtos.ExceptionDto;
import com.yash.productservicejune24.exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<ExceptionDto> handleArithmeticException(){
        ExceptionDto exceptionDto = new ExceptionDto();

        exceptionDto.setMessage("ArithmeticException Occured");
        exceptionDto.setSolution("Please avoid using divided by zero concpet");

        return new ResponseEntity<>(
                exceptionDto,
                HttpStatus.BAD_REQUEST
        );
        //return response;
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ExceptionDto> handleProductNotFoundException(ProductNotFoundException pnf){
        ExceptionDto exceptionDto = new ExceptionDto();

        exceptionDto.setMessage(pnf.getMessage());
        exceptionDto.setSolution("Please enter the correct product id");

        return new ResponseEntity<>(
             exceptionDto,
             HttpStatus.OK
        );
    }
}
