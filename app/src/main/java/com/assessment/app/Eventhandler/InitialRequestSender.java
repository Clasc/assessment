package com.assessment.app.Eventhandler;

import com.assessment.app.Clients.QueryServiceClient;
import com.assessment.app.Models.PostCall;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class InitialRequestSender {
    private final QueryServiceClient queryServiceClient;
    private final static String InitMessage = "App Startup";

    public InitialRequestSender(QueryServiceClient queryServiceClient) {
        this.queryServiceClient = queryServiceClient;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void handleContextRefreshEvent(ApplicationReadyEvent event) {
        System.out.println("Context started. Sending initial request...");
        queryServiceClient.post("/api/v1/call", new PostCall(InitMessage));
    }
}
