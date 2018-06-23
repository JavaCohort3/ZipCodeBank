package com.example.javacohort3.ZipCodeBank.exceptions;

import org.springframework.http.HttpStatus;

public class ResponseDetails {
    private Integer code;
    private String message;
    private Object data;

    public ResponseDetails() {
    }

    public ResponseDetails(HttpStatus status, String message) {
        this.code = status.value();
        this.message = message;
    }
    public ResponseDetails(HttpStatus status, String message, Object data) {
        this.code = status.value();
        this.message = message;
        this.data = data;

    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResponseDetails{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data='" + data + '\'' +
                '}';
    }
}
