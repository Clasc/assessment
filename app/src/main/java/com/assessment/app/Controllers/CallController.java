package com.assessment.app.Controllers;

import java.util.List;

import com.assessment.app.Clients.QueryServiceClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class CallController {
    private final QueryServiceClient queryServiceClient;

    @Autowired
    public CallController(QueryServiceClient queryServiceClient) {
        this.queryServiceClient = queryServiceClient;
    }

    @GetMapping("/api/v1/calls")
    public ResponseEntity<String> get() {
        return ResponseEntity.ok(queryServiceClient.get("/api/v1/calls"));
    }

    @PostMapping("/api/v1/call")
    public ResponseEntity<String> call(@RequestBody String message) {
        queryServiceClient.post("/api/v1/call", message);
        return ResponseEntity.ok("ok");
    }
}
