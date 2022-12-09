package com.java.streamingservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// import io.swagger.v3.oas.annotations.Operation;

@CrossOrigin
@RestController
@RequestMapping("streaming")
public class StreamingController {

	/**
	 * 	@Operation(summary = "Create movie data")
	public ResponseEntity<Movies> create(MoviesDto moviesDto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(moviesService.create(moviesDto));
	}
	 */

	
}
