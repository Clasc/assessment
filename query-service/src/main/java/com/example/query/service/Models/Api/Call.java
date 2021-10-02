package com.example.query.service.Models.Api;

import java.sql.Timestamp;

public class Call {
    private String message;
    private Timestamp created;

    public Timestamp getCreated() {
        return created;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }
}
