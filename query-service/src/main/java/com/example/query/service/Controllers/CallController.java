package com.example.query.service.Controllers;

import java.util.UUID;

import com.example.query.service.Services.CallService;
import com.example.query.service.Models.PostCall;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class CallController {
    private final CallService callService;

    @Autowired
    public CallController(CallService callService) {
        this.callService = callService;
    }

    @PostMapping("/api/v1/call")
    public UUID call(@RequestBody PostCall request) {
        return callService.addCall(request.getMessage());
    }

    @GetMapping("/api/v1/calls")
    public String calls() {
        return callService.getCalls();
    }
}
