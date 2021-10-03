package com.assessment.app.Clients;

import com.assessment.app.Models.PostCall;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class QueryServiceClient {
    private String host = "http://query-service:8002";
    private RestTemplate rest;
    private HttpHeaders headers;
    private HttpStatus status;

    @Autowired
    public QueryServiceClient() {
        this.rest = new RestTemplate();
        this.headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        headers.add("Accept", "*/*");
    }

    public String get(String uri) {
        HttpEntity<String> requestEntity = new HttpEntity<String>("", headers);
        ResponseEntity<String> responseEntity = rest.exchange(host + uri, HttpMethod.GET, requestEntity, String.class);
        this.setStatus(responseEntity.getStatusCode());
        return responseEntity.getBody();
    }

    public String post(String uri, PostCall request) {
        HttpEntity<PostCall> requestEntity = new HttpEntity<PostCall>(request, headers);
        ResponseEntity<String> responseEntity = rest.exchange(host + uri, HttpMethod.POST, requestEntity, String.class);
        this.setStatus(responseEntity.getStatusCode());
        return responseEntity.getBody();
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void handleContextRefreshEvent(ApplicationReadyEvent event) {
        System.out.println("Context started. Sending initial Request...");
        post("/api/v1/call", new PostCall("startup"));
    }
}