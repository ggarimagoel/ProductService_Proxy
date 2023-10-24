package com.example.ProductServiceProxy.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;

//@ControllerAdvice
public class ExceptionAdvices {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e){
        return new ResponseEntity<>("error has occoured", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
