package com.java.moviesservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.java.moviesservice.dto.MoviesDto;
import com.java.moviesservice.model.Movies;
import com.java.moviesservice.service.MoviesService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@CrossOrigin
@RestController
@Tag(name = "Movies endpoint")
public class MoviesController implements MoviesControllerInterface {

	@Autowired
	private MoviesService moviesService;

	@Override
	@Operation(summary = "Create movie data")
	public ResponseEntity<Movies> create(MoviesDto moviesDto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(moviesService.create(moviesDto));
	}

	@Override
	@Operation(summary = "Show all movies")
	public ResponseEntity<List<Movies>> findAll() {
		return ResponseEntity.status(HttpStatus.OK).body(moviesService.listAll());
	}

	@Override
	@Operation(summary = "Show a movie by id")
	public ResponseEntity<Movies> findById(Integer id) {
		return ResponseEntity.status(HttpStatus.OK).body(moviesService.findById(id));
	}

	@Override
	@Operation(summary = "Update a movie by id")
	public ResponseEntity<Movies> update(Integer id, MoviesDto moviesDto) {
		return ResponseEntity.status(HttpStatus.OK).body(moviesService.update(id, moviesDto));
	}

	@Override
	@Operation(summary = "Delete a movie by id")
	public ResponseEntity<Object> deleteById(Integer id) {
		moviesService.delete(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

}
