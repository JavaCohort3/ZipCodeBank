package com.example.javacohort3.ZipCodeBank.exceptions;

public class ResponseDetails {
    private String title;
    private int status;
    private String detail;
    private long timeStamp;
    private String developerMessage;
    private Throwable errors;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getDeveloperMessage() {
        return developerMessage;
    }

    public void setDeveloperMessage(String developerMessage) {
        this.developerMessage = developerMessage;
    }
    public Throwable getErrors(){
        return errors;
    }

    public void setErrors(Throwable errors) {
        this.errors = errors;
    }

    @Override
    public String toString() {
        return "ErrorDetail{" +
                "title='" + title + '\'' +
                ", status=" + status +
                ", detail='" + detail + '\'' +
                ", timeStamp=" + timeStamp +
                ", developerMessage='" + developerMessage + '\'' +
                ", errors=" + errors +
                '}';
    }
}
