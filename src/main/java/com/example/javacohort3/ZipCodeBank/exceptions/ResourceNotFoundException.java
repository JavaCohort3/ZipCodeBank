package com.example.javacohort3.ZipCodeBank.exceptions;

import org.springframework.http.HttpStatus;

public class ResourceNotFoundException extends RuntimeException {
    private HttpStatus status;
    private String details;

    public ResourceNotFoundException() {}

    public ResourceNotFoundException(String details) {
        super(details);
    }

    public ResourceNotFoundException(HttpStatus status,String details){
        this.status = status;
        this.details = details;
    }

    public ResourceNotFoundException(String details, Throwable cause) {
        super(details, cause);
    }

    public ResourceNotFoundException(Throwable cause) {
        super(cause);
    }

    public ResourceNotFoundException(String details, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(details, cause, enableSuppression, writableStackTrace);
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    @Override
    public String getMessage() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
