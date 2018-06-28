package com.example.javacohort3.ZipCodeBank.exceptions;


import org.hibernate.PersistentObjectException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.fasterxml.jackson.core.JsonParseException;
@ControllerAdvice
public class RestExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(SpringApplication.class);

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> handleAccountNotFoundException(ResourceNotFoundException rnfe){
        return new ResponseEntity<>(new ErrorDetails(rnfe.getStatus(),rnfe.getMessage()),rnfe.getStatus());
    }

    @ExceptionHandler(IllegalStateException.class)
    public ResponseEntity<?> handleIllegalStateException(IllegalStateException ise){

        return new ResponseEntity<>(new ErrorDetails(HttpStatus.INTERNAL_SERVER_ERROR,"Can not have the same entity more than one "+ " :  " + "Follow us on Github | - JavaCohort | Zay, Manny, Blaude, Jermaine, Zamir , & JoJo"),HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(PersistentObjectException.class)
    public ResponseEntity<?> handlePersistentObjectException(PersistentObjectException poe){
        return new ResponseEntity<>(new ErrorDetails(HttpStatus.INTERNAL_SERVER_ERROR,poe.getLocalizedMessage() + "   " + "Follow us on Github | - JavaCohort | Zay, Manny, Blaude, Jermaine, Zamir , & JoJo"),HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(JsonParseException.class)
    public ResponseEntity<?> handleJsonParseException(JsonParseException jpe){
        return new ResponseEntity<>(new ErrorDetails(HttpStatus.BAD_REQUEST,jpe.getLocalizedMessage() + "   " + "Follow us on Github | - JavaCohort | Zay, Manny, Blaude, Jermaine, Zamir , & JoJo"),HttpStatus.BAD_REQUEST);
    }
}
