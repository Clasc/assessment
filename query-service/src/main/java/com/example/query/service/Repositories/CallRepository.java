package com.example.query.service.Repositories;

import com.example.query.service.Models.Entities.CallEntity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CallRepository extends JpaRepository<CallEntity, Long> {

}
