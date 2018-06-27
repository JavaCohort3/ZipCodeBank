package com.example.javacohort3.ZipCodeBank.exceptions;


import com.fasterxml.jackson.core.JsonParseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> handleAccountNotFoundException(ResourceNotFoundException rnfe){
        return new ResponseEntity<>(new ErrorDetails(rnfe.getStatus(),rnfe.getMessage()),rnfe.getStatus());
    }

    @ExceptionHandler(JsonParseException.class)
    public ResponseEntity<?> handleJsonParseException(JsonParseException jpe){
        return new ResponseEntity<>(new ErrorDetails(HttpStatus.BAD_REQUEST,"|| Java Cohort 3 || " + jpe.getMessage()),HttpStatus.BAD_REQUEST);
    }

}
