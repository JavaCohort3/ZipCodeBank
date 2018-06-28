package com.example.javacohort3.ZipCodeBank.exceptions;

import org.springframework.http.HttpStatus;

public class DeleteResponse {
    private Integer code;
    private String message;

    public DeleteResponse() {
    }

    public DeleteResponse(HttpStatus status, String message) {
        this.code = status.value();
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(HttpStatus status) {
        this.code = status.value();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "DeleteResponse{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }
}
