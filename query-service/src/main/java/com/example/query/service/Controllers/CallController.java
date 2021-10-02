package com.example.query.service.Controllers;

import java.util.List;
import com.example.query.service.Models.Api.Call;
import com.example.query.service.Models.Api.PostCall;
import com.example.query.service.Services.CallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/api/v1/calls")
    public ResponseEntity<List<Call>> get() {
        return ResponseEntity.ok(callService.getCalls());
    }

    @PostMapping("/api/v1/call")
    public ResponseEntity<Long> call(@RequestBody PostCall request) {
        return ResponseEntity.ok(callService.addCall(request.getMessage()));
    }
}
