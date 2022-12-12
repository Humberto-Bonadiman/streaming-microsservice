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
@Tag(name = "Streaming endpoint")
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
		return ResponseEntity.status(HttpStatus.OK).body(streamingService.listAll());
	}

	@Override
	@Operation(summary = "Find a streaming data by id")
	public ResponseEntity<Streaming> findById(Integer id) {
		return ResponseEntity.status(HttpStatus.OK).body(streamingService.findById(id));
	}

	@Override
	@Operation(summary = "Delete a streaming data by id")
	public ResponseEntity<Object> deleteById(Integer id) {
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

	@Override
	@Operation(summary = "Add a movie in streaming data")
	public ResponseEntity<Streaming> updateWithMovie(Integer id, Integer idMovie) {
		return ResponseEntity
            .status(HttpStatus.OK)
            .body(streamingService.updateWithMovies(id, idMovie));
	}

	@Override
	@Operation(summary = "Add a serie in streaming data")
	public ResponseEntity<Streaming> updateWithSerie(Integer id, Integer idSerie) {
		return ResponseEntity
	        .status(HttpStatus.OK)
	        .body(streamingService.updateWithMovies(id, idSerie));
	}
}
