package com.java.moviesservice.controller;

import com.java.moviesservice.dto.MoviesDto;
import com.java.moviesservice.model.Movies;

import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/movies-service")
public interface MoviesControllerInterface {

	  @PostMapping
	  @ApiResponses(value = {
	      @ApiResponse(responseCode = "201", description = "Create a movie", 
	          content = { @Content(mediaType = "application/json", 
	          schema = @Schema(implementation = Movies.class)) }),
	      @ApiResponse(responseCode = "400", description = "Wrong format",
	          content = @Content)})
	  public ResponseEntity<Movies> create(@RequestBody MoviesDto moviesDto);

	  @GetMapping
	  @ApiResponses(value = {
	      @ApiResponse(responseCode = "200", description = "Show all movies", 
	          content = { @Content(mediaType = "application/json", 
	          array = @ArraySchema(schema = @Schema(implementation = Movies.class))) })})
	  public ResponseEntity<List<Movies>> findAll();

	  @GetMapping("/{id}")
	  @ApiResponses(value = {
		      @ApiResponse(responseCode = "200", description = "Show a movie by id",
		          content = { @Content(mediaType = "application/json", 
		    	  schema = @Schema(implementation = Movies.class)) }),
		      @ApiResponse(responseCode = "404", description = "Movie not found",
		          content = @Content)})
      public ResponseEntity<Movies> findById(@PathVariable Integer id);

	  @PatchMapping("/{id}")
	  @ApiResponses(value = {
		      @ApiResponse(responseCode = "200", description = "Update a movie",
		          content = { @Content(mediaType = "application/json", 
		    	  schema = @Schema(implementation = Movies.class)) }),
		      @ApiResponse(responseCode = "404", description = "Movie not found",
		          content = @Content)})
	  public ResponseEntity<Movies> update(@PathVariable Integer id, @RequestBody MoviesDto moviesDto);

	  @DeleteMapping("/{id}")
	  @ApiResponses(value = {
	      @ApiResponse(responseCode = "204", content = @Content),
	      @ApiResponse(responseCode = "404", description = "Movie not found",
	          content = @Content)})
	  public ResponseEntity<Object> deleteById(@PathVariable Integer id);
}
