package com.java.seriesservice.controller;

import com.java.seriesservice.dto.SeriesDto;
import com.java.seriesservice.model.Series;
import com.java.seriesservice.service.SeriesService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@Tag(name = "Series endpoint")
public class SeriesController implements SeriesControllerInterface {

	@Autowired
	SeriesService seriesService;

	@Override
	public ResponseEntity<Series> create(SeriesDto seriesDto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(seriesService.create(seriesDto));
	}

	@Override
	public ResponseEntity<List<Series>> findAll() {
		return ResponseEntity.status(HttpStatus.OK).body(seriesService.listAll());
	}

	@Override
	public ResponseEntity<Series> findById(Integer id) {
		return ResponseEntity.status(HttpStatus.OK).body(seriesService.findById(id));
	}

	@Override
	public ResponseEntity<Series> update(Integer id, SeriesDto seriesDto) {
		return ResponseEntity.status(HttpStatus.OK).body(seriesService.update(id, seriesDto));
	}

	@Override
	public ResponseEntity<Object> deleteById(Integer id) {
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}
