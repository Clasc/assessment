package com.example.query.service.Services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CallService {
    @Autowired
    public CallService() {
        super();
    }

    public UUID addCall(String message) {
        System.out.println("received call");
        System.out.println(message);
        return UUID.randomUUID();
    }

    public String getCalls() {
        return "get calls";
    }
}
