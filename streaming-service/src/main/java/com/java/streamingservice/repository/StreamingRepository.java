package com.java.streamingservice.repository;

import com.java.streamingservice.model.Streaming;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StreamingRepository extends JpaRepository<Streaming, Integer> {}
