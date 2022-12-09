package com.java.streamingservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.java.streamingservice.model.Streaming;

public interface StreamingRepository extends MongoRepository<Streaming, String> {}
