package com.example.query.service.Services;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.example.query.service.Models.Api.Call;
import com.example.query.service.Models.Entities.CallEntity;
import com.example.query.service.Repositories.CallRepository;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.modelmapper.config.Configuration.AccessLevel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CallService {
    private final CallRepository callRepo;

    @Autowired
    public CallService(CallRepository callRepository) {
        callRepo = callRepository;
    }

    public long addCall(String message) {
        System.out.println("received call");
        System.out.println(message);
        var currenttime = new Timestamp(System.currentTimeMillis());
        var call = new CallEntity(message, currenttime);
        return callRepo.save(call).getId();
    }

    public List<Call> getCalls() {
        var mapper = new ModelMapper();
        mapper.getConfiguration().setFieldMatchingEnabled(true).setFieldAccessLevel(AccessLevel.PRIVATE);
        var entities = callRepo.findAll();
        List<Call> result = mapper.map(entities, new TypeToken<ArrayList<Call>>() {
        }.getType());
        return result;
    }
}
