package com.java.streamingservice.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.java.streamingservice.response.Series;
import com.java.streamingservice.response.SeriesDto;

@FeignClient(name = "series-service")
public interface SeriesProxy {

	@GetMapping(value = "/series-service/{id}")
	public Series getSerie(@PathVariable("id") Integer id);

	@PostMapping(value = "series-service")
	public Series createSerie(@RequestBody SeriesDto serieDto);

	@DeleteMapping(value = "/series-service/{id}")
	public void deleteSerie(@PathVariable("id") Integer id);
}
