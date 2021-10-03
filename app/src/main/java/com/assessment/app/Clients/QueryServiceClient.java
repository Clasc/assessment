package com.assessment.app.Clients;

import com.assessment.app.Models.PostCall;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class QueryServiceClient {

    @Value("${query.service.hostname}")
    private String host;

    @Value("${query.service.port}")
    private String port;

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

    public String getBaseUrl() {
        return host + ":" + port;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String get(String uri) {
        HttpEntity<String> requestEntity = new HttpEntity<String>("", headers);
        ResponseEntity<String> responseEntity = rest.exchange(getBaseUrl() + uri, HttpMethod.GET, requestEntity,
                String.class);
        this.setStatus(responseEntity.getStatusCode());
        return responseEntity.getBody();
    }

    public String post(String uri, PostCall request) {
        HttpEntity<PostCall> requestEntity = new HttpEntity<PostCall>(request, headers);
        ResponseEntity<String> responseEntity = rest.exchange(getBaseUrl() + uri, HttpMethod.POST, requestEntity,
                String.class);
        this.setStatus(responseEntity.getStatusCode());
        return responseEntity.getBody();
    }

}