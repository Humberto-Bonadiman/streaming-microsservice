package com.java.streamingservice.controller;

import com.java.streamingservice.dto.StreamingDto;
import com.java.streamingservice.model.Streaming;
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
// import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/streaming")
public interface StreamingControllerInterface {

	  @PostMapping
	  @ApiResponses(value = {
	      @ApiResponse(responseCode = "201", description = "Create a streaming data", 
	          content = { @Content(mediaType = "application/json", 
	          schema = @Schema(implementation = Streaming.class)) }),
	      @ApiResponse(responseCode = "400", description = "Wrong format",
	          content = @Content)})
	  public ResponseEntity<Streaming> create(@RequestBody StreamingDto streamingDto);

	  @GetMapping
	  @ApiResponses(value = {
	      @ApiResponse(responseCode = "200", description = "Show all streaming data", 
	          content = { @Content(mediaType = "application/json", 
	          array = @ArraySchema(schema = @Schema(implementation = Streaming.class))) })})
	  public ResponseEntity<List<Streaming>> findAll();

	  // @GetMapping
	  // public ResponseEntity<> showAllServices();

	  @GetMapping("/{id}")
	  @ApiResponses(value = {
		      @ApiResponse(responseCode = "200", description = "Show a streaming by id",
		          content = { @Content(mediaType = "application/json", 
		    	  schema = @Schema(implementation = Streaming.class)) }),
		      @ApiResponse(responseCode = "404", description = "Streaming not found",
		          content = @Content)})
      public ResponseEntity<Streaming> findById(@PathVariable String id);

	  @PatchMapping("/{id}/with/{idMovie}")
	  @ApiResponses(value = {
		      @ApiResponse(responseCode = "200", description = "Update a streaming with a movie",
		          content = { @Content(mediaType = "application/json", 
		    	  schema = @Schema(implementation = Streaming.class)) }),
		      @ApiResponse(responseCode = "404", description = "Streaming not found",
		          content = @Content)})
	  public ResponseEntity<Streaming> updateWithMovie(
          @PathVariable String id,
          @PathVariable String idMovie
      );


	  @DeleteMapping("/{id}")
	  @ApiResponses(value = {
	      @ApiResponse(responseCode = "204", content = @Content),
	      @ApiResponse(responseCode = "404", description = "Streaming not found",
	          content = @Content)})
	  public ResponseEntity<Object> deleteById(@PathVariable String id);
}
