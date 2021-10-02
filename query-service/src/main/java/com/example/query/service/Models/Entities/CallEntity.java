package com.example.query.service.Models.Entities;

import javax.persistence.Entity;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "calls")
public class CallEntity {
    public CallEntity() {
    }

    public CallEntity(String message, Timestamp created) {
        this.message = message;
        this.created = created;
    }

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "message")
    private String message;

    @Column(name = "created", nullable = false)
    private Timestamp created;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}