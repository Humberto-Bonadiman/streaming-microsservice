package com.java.streamingservice.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.java.streamingservice.response.Series;

@FeignClient(name = "series-service")
public interface SeriesProxy {

	@GetMapping(value = "/series-service/{id}")
	public Series getSerie(@PathVariable("id") String id);
}
