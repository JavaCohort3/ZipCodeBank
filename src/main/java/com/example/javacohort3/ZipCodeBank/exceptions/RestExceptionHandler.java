package com.example.javacohort3.ZipCodeBank.exceptions;


import org.hibernate.PersistentObjectException;
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

    @ExceptionHandler(IllegalStateException.class)
    public ResponseEntity<?> handleIllegalStateException(IllegalStateException ise){
        return new ResponseEntity<>(new ErrorDetails(HttpStatus.INTERNAL_SERVER_ERROR,"Can not have the same entity more than one "+ " :  " + "Follow us on Github | - JavaCohort | Zay, Manny, Blaude, Jermaine, Zamir , & JoJo"),HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(PersistentObjectException.class)
    public ResponseEntity<?> handlePersistentObjectException(PersistentObjectException poe){
        return new ResponseEntity<>(new ErrorDetails(HttpStatus.INTERNAL_SERVER_ERROR,poe.getLocalizedMessage() + "   " + "Follow us on Github | - JavaCohort | Zay, Manny, Blaude, Jermaine, Zamir , & JoJo"),HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
