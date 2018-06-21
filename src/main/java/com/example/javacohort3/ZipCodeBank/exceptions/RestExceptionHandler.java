package com.example.javacohort3.ZipCodeBank.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(io.elitejava3.BankAPI.exceptions.ResourceNotFoundException.class)
    public ResponseEntity<?> handleAccountNotFoundException(io.elitejava3.BankAPI.exceptions.ResourceNotFoundException anfe){
        io.elitejava3.BankAPI.exceptions.ResponseDetails responseDetails = new io.elitejava3.BankAPI.exceptions.ResponseDetails();
        responseDetails.setStatus(HttpStatus.NOT_FOUND.value());
        responseDetails.setMessage("“error fetching accounts”");

        return new ResponseEntity<>(responseDetails,HttpStatus.NOT_FOUND);
    }

}
