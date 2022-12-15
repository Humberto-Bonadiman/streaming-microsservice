package com.java.streamingservice.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.java.streamingservice.response.Movies;
import com.java.streamingservice.response.MoviesDto;

@FeignClient(name = "movies-service")
public interface MoviesProxy {

	@GetMapping(value = "/movies-service/{id}")
	public Movies getMovie(@PathVariable("id") Integer id);

	@PostMapping(value = "/movies-service")
	public Movies createMovie(@RequestBody MoviesDto movieDto);

	@DeleteMapping(value = "/movies-service/{id}")
	public void deleteMovie(@PathVariable("id") Integer id);
}
