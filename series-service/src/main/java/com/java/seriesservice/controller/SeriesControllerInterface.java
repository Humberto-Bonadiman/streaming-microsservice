package com.java.seriesservice.controller;

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

import com.java.seriesservice.dto.SeriesDto;
import com.java.seriesservice.model.Series;

@RequestMapping("/series-service")
public interface SeriesControllerInterface {

	  @PostMapping
	  @ApiResponses(value = {
	      @ApiResponse(responseCode = "201", description = "Create a serie", 
	          content = { @Content(mediaType = "application/json", 
	          schema = @Schema(implementation = Series.class)) }),
	      @ApiResponse(responseCode = "400", description = "Wrong format",
	          content = @Content)})
	  public ResponseEntity<Series> create(@RequestBody SeriesDto seriesDto);

	  @GetMapping
	  @ApiResponses(value = {
	      @ApiResponse(responseCode = "200", description = "Show all series", 
	          content = { @Content(mediaType = "application/json", 
	          array = @ArraySchema(schema = @Schema(implementation = Series.class))) })})
	  public ResponseEntity<List<Series>> findAll();

	  @GetMapping("/{id}")
	  @ApiResponses(value = {
		      @ApiResponse(responseCode = "200", description = "Show a serie by id",
		          content = { @Content(mediaType = "application/json", 
		    	  schema = @Schema(implementation = Series.class)) }),
		      @ApiResponse(responseCode = "404", description = "Series not found",
		          content = @Content)})
      public ResponseEntity<Series> findById(@PathVariable String id);

	  @PatchMapping("/{id}")
	  @ApiResponses(value = {
		      @ApiResponse(responseCode = "200", description = "Update a serie",
		          content = { @Content(mediaType = "application/json", 
		    	  schema = @Schema(implementation = Series.class)) }),
		      @ApiResponse(responseCode = "404", description = "Series not found",
		          content = @Content)})
	  public ResponseEntity<Series> update(@PathVariable String id, @RequestBody SeriesDto seriesDto);

	  @DeleteMapping("/{id}")
	  @ApiResponses(value = {
	      @ApiResponse(responseCode = "204", content = @Content),
	      @ApiResponse(responseCode = "404", description = "Series not found",
	          content = @Content)})
	  public ResponseEntity<Object> deleteById(@PathVariable String id);
}
