package com.example.javacohort3.ZipCodeBank.exceptions;

import org.springframework.http.HttpStatus;

public class ErrorDetails {
    private Integer code;
    private String message;


    public ErrorDetails(Integer status, String message) {
        this.code = status;
        this.message = message;
    }

    public ErrorDetails(HttpStatus httpStatus, String message) {
        this.code = httpStatus.value();
        this.message = message;
    }


    public Integer getCode() {
        return code;
    }

    public void setCode(HttpStatus httpStatus) {
        this.code = httpStatus.value();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
