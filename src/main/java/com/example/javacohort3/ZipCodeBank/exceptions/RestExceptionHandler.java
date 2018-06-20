package com.example.javacohort3.ZipCodeBank.exceptions;

import com.fasterxml.jackson.core.JsonParseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> handlePersonNotFoundException(ResourceNotFoundException rnfe, HttpServletRequest req){
        ResponseDetails responseDetails = new ResponseDetails();
        responseDetails.setTimeStamp(new Date().getTime());
        responseDetails.setStatus(HttpStatus.NOT_FOUND.value());
        responseDetails.setTitle("Person Not Found");
        responseDetails.setDetail(rnfe.getMessage());
        responseDetails.setDeveloperMessage(rnfe.getClass().getName());
        String requestPath = (String) req.getAttribute("javax.servlet.error. request_uri");
        if(requestPath == null) {
            req.getRequestURI();
        }
        return new ResponseEntity<>(responseDetails,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<?> handleNotReadableMessageExpection(HttpMessageNotReadableException hmnre){
        ResponseDetails responseDetails = new ResponseDetails();
        responseDetails.setTitle("RestExpectionHandler active");
        responseDetails.setTimeStamp(new Date().getTime());
        responseDetails.setDetail(hmnre.getMessage());
        responseDetails.setStatus(HttpStatus.BAD_REQUEST.value());
        responseDetails.setDeveloperMessage(hmnre.getLocalizedMessage());
        responseDetails.setErrors(hmnre.fillInStackTrace());

        return new ResponseEntity<>(responseDetails,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<?> handleRequestMethodNotSupported(HttpRequestMethodNotSupportedException hrmnse){
        ResponseDetails responseDetails = new ResponseDetails();
        responseDetails.setTitle("Request Method Not Supported");
        responseDetails.setTimeStamp(new Date().getTime());
        responseDetails.setDetail(hrmnse.getMethod() + " || " + hrmnse.getMessage());
        responseDetails.setStatus(HttpStatus.BAD_REQUEST.value());
        responseDetails.setDeveloperMessage(hrmnse.getLocalizedMessage());
        responseDetails.setErrors(hrmnse.fillInStackTrace());
        return new ResponseEntity<>(responseDetails,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(TransactionSystemException.class)
    public ResponseEntity<?> handleHttpMessageNotWritableException(TransactionSystemException tse){
        ResponseDetails responseDetails = new ResponseDetails();
        responseDetails.setTitle("TransactionSystemException");
        responseDetails.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        responseDetails.setTimeStamp(new Date().getTime());
        responseDetails.setDeveloperMessage(tse.getMessage());
        responseDetails.setErrors(tse.getCause().fillInStackTrace());
        responseDetails.setDetail(tse.getLocalizedMessage());
        return new ResponseEntity<>(responseDetails,HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @ExceptionHandler(JsonParseException.class)
    public ResponseEntity<?> handleJsonParseException(JsonParseException jpe) {
        ResponseDetails responseDetails = new ResponseDetails();
        responseDetails.setTitle("JSONParseException");
        responseDetails.setStatus(HttpStatus.BAD_REQUEST.value());
        responseDetails.setTimeStamp(new Date().getTime());
        responseDetails.setDeveloperMessage(jpe.getMessage());
        responseDetails.setErrors(jpe.getCause().fillInStackTrace());
        responseDetails.setDetail(jpe.getLocalizedMessage());
        return new ResponseEntity<>(responseDetails, HttpStatus.BAD_REQUEST);
    }
}
