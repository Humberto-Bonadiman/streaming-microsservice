package com.java.streamingservice.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.java.streamingservice.response.Movies;

@FeignClient(name = "movies-service")
public interface MoviesProxy {

	@GetMapping(value = "/movies-service/{id}")
	public Movies getMovie(@PathVariable("id") Integer id); 
}
