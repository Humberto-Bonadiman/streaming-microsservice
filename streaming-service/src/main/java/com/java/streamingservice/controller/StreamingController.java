package com.java.streamingservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.java.streamingservice.dto.StreamingDto;
import com.java.streamingservice.model.Streaming;
import com.java.streamingservice.service.StreamingService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

// import io.swagger.v3.oas.annotations.Operation;

@CrossOrigin
@RestController
@Tag(name = "Movies endpoint")
public class StreamingController implements StreamingControllerInterface {

	@Autowired
	StreamingService streamingService;

	@Override
	@Operation(summary = "Create streaming data")
	public ResponseEntity<Streaming> create(StreamingDto streamingDto) {
    	return ResponseEntity.status(HttpStatus.CREATED).body(streamingService.create(streamingDto));
    }

	@Override
	@Operation(summary = "Show all streaming data")
	public ResponseEntity<List<Streaming>> findAll() {
		return ResponseEntity.status(HttpStatus.OK).body(streamingService.showAll());
	}

	@Override
	@Operation(summary = "Find a streaming data by id")
	public ResponseEntity<Streaming> findById(String id) {
		return ResponseEntity.status(HttpStatus.OK).body(streamingService.findById(id));
	}

	/**
	 * 	@Override
	public ResponseEntity<Streaming> update(String id, StreamingDto streamingDto) {
		return ResponseEntity.status(HttpStatus.OK).body(streamingService)
	}
	 */

	@Override
	@Operation(summary = "Delete a streaming data by id")
	public ResponseEntity<Object> deleteById(String id) {
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}
