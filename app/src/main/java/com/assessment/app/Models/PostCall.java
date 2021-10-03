package com.assessment.app.Models;

public class PostCall {
    private String message;

    public PostCall() {
    }

    public PostCall(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
