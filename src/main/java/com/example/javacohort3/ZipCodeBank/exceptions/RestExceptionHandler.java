package com.example.javacohort3.ZipCodeBank.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> handleAccountNotFoundException(ResourceNotFoundException anfe){
        ResponseDetails responseDetails = new ResponseDetails();
        responseDetails.setStatus(HttpStatus.NOT_FOUND.value());
        responseDetails.setMessage("“error fetching accounts”");

        return new ResponseEntity<>(responseDetails,HttpStatus.NOT_FOUND);
    }

}
